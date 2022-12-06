package mx.htsoft.spring.boot.microservices.app.item.security;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.Calendar;
import java.util.Enumeration;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;

@Service
public class JWTService {
	
	public final static Charset UTF8_CHARSET = Charset.forName("UTF-8");
	public static KeyStore myStore = null;
	public static FileInputStream in_cert = null;
	public String jwt;
	
	public JWTService() {
		PrivateKey privateKey = null;
		
		try {
			File p12 = new File(getClass().getClassLoader().getResource("certificate.p12").getFile());
			in_cert = new FileInputStream(p12);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			myStore = KeyStore.getInstance("PKCS12");
			myStore.load(in_cert, "1234".toCharArray());
			String alias = "";
			
			Enumeration objEnumeration = myStore.aliases();
			while(objEnumeration.hasMoreElements() == true) {
				alias = (String) objEnumeration.nextElement();
				privateKey = (PrivateKey) myStore.getKey(alias, "1234".toCharArray());
				System.out.println(privateKey.getFormat());
			}
		}catch(Exception e1){
			e1.printStackTrace();
		}
		
		JsonObject header = new JsonObject(); 
		header.addProperty("alg", "RSA256");
		header.addProperty("typ", "JWT");
		
		Calendar cal = Calendar.getInstance();
		cal.set(1970, 01, 01);
		String iat = Long.toString((System.currentTimeMillis() - cal.getTimeInMillis())/1000);
		String exp = Long.toString((System.currentTimeMillis() - cal.getTimeInMillis())/1000 + 6000L);
		
		JsonObject claim = new JsonObject();
		claim.addProperty("acces_type", "offline");
		claim.addProperty("exp", exp);
		claim.addProperty("iat", iat);
		
		System.out.println("Header : " + header);
		String headerStr = header.toString();
		System.out.println("claim : " + claim);
		String claimStr = claim.toString();
		
		try {
			byte[] headerArr = headerStr.getBytes(UTF8_CHARSET);
			System.out.println(Base64.encodeBase64URLSafeString(headerArr));
			
			byte[] claimArr = claimStr.getBytes(UTF8_CHARSET);
			System.out.println(Base64.encodeBase64URLSafeString(claimArr));
			
			String inputStr = Base64.encodeBase64URLSafe(headerArr) + "," + Base64.encodeBase64URLSafeString(claimArr);
			
			Signature signature = Signature.getInstance("SHA256withRSA");
			signature.initSign(privateKey);
			signature.update(inputStr.getBytes(UTF8_CHARSET));
			
			System.out.println("Token JWT PERRO: " + Base64.encodeBase64URLSafeString(headerArr) + "." + Base64.encodeBase64URLSafeString(claimArr) + "." + Base64.encodeBase64URLSafeString(signature.sign()));
			
            jwt = Base64.encodeBase64URLSafeString(headerArr) + "." + Base64.encodeBase64URLSafeString(claimArr) + "." + Base64.encodeBase64URLSafeString(signature.sign());
            
            System.out.println("Token: " + jwt);
			
            
		}catch(Exception e2) {
			e2.printStackTrace();
		}
	}


}
