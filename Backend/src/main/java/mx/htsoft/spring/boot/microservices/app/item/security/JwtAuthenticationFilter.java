 package mx.htsoft.spring.boot.microservices.app.item.security;

 import io.jsonwebtoken.*;
 import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
 import org.springframework.security.core.authority.SimpleGrantedAuthority;
 import org.springframework.security.core.context.SecurityContextHolder;
 import org.springframework.web.filter.OncePerRequestFilter;

 import javax.servlet.FilterChain;
 import javax.servlet.ServletException;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import java.io.File;
 import java.io.FileInputStream;
 import java.io.FileNotFoundException;
 import java.io.IOException;
 import java.security.Key;
 import java.security.KeyPair;
 import java.security.KeyStore;
 import java.security.PrivateKey;
 import java.security.cert.Certificate;
 import java.util.Enumeration;
 import java.util.List;
 import java.util.stream.Collectors;

 public class JwtAuthenticationFilter extends OncePerRequestFilter {

     private final String HEADER = "Authorization";
     private final String PREFIX = "Token ";

     private FileInputStream in_cert = null;
     public Key key = null;
     public Certificate cert = null;
     public KeyPair kp;
     private KeyStore store = null;

     @Override
     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
         try {
             if (checkJWTToken(request, response)) {
                 Claims claims = validateToken(request);
                 if (claims.get("authorities") != null) {
                     setUpSpringAuthentication(claims);
                 } else {
                     SecurityContextHolder.clearContext();
                 }
             }else {
                 SecurityContextHolder.clearContext();
             }
             filterChain.doFilter(request, response);
         } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
             response.setStatus(HttpServletResponse.SC_FORBIDDEN);
             ((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
             return;
         }
     }

     private Claims validateToken(HttpServletRequest request) {
         String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
         System.out.println(jwtToken);
         //return Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(jwtToken).getBody();
         return Jwts.parser().setSigningKey(getKeyPair().getPublic()).parseClaimsJws(jwtToken).getBody();
     }

     /**
      * Authentication method in Spring flow
      *
      * @param claims
      */
     private void setUpSpringAuthentication(Claims claims) {
         List<String> authorities = (List) claims.get("authorities");

         UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(claims.getSubject(), null,
                 authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
         SecurityContextHolder.getContext().setAuthentication(auth);

     }

     private boolean checkJWTToken(HttpServletRequest request, HttpServletResponse res) {
         String authenticationHeader = request.getHeader(HEADER);
         System.out.println("Peticiones solicitadas");
         System.out.println("Solicitud "+request.getHeader(HEADER));
         System.out.println("Correspondiente a: "+request.getContextPath());
         System.out.println("Peticion al servidor: "+request.getMethod()+" hacia "+request.getRequestURI());
         if (authenticationHeader == null || !authenticationHeader.startsWith(PREFIX))
             return false;
         return true;
     }

     private KeyPair getKeyPair(){
         try{
             File p12 = new File(getClass().getClassLoader().getResource("certificate.p12").getFile());
             in_cert = new FileInputStream(p12);
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         }

         try {
             store = KeyStore.getInstance("PKCS12");
             store.load(in_cert, "1234".toCharArray());

             Enumeration aliasEnum = store.aliases();
             while (aliasEnum.hasMoreElements()) {
                 String keyName = (String) aliasEnum.nextElement();
                 key = store.getKey(keyName, "1234".toCharArray());
                 cert = store.getCertificate(keyName);
             }

             kp = new KeyPair(cert.getPublicKey(), (PrivateKey) key);
         } catch (Exception ex){
             System.out.println(ex.getMessage());
         }

         return kp;
     }
 }