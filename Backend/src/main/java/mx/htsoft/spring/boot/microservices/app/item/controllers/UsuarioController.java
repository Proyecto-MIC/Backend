package mx.htsoft.spring.boot.microservices.app.item.controllers;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nimbusds.jose.shaded.json.JSONObject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import mx.htsoft.spring.boot.microservices.app.item.interfaze.IUser_rol;
import mx.htsoft.spring.boot.microservices.app.item.interfaze.IUsuario;
import mx.htsoft.spring.boot.microservices.app.item.models.Usuario;
import mx.htsoft.spring.boot.microservices.app.item.models.sendToken;
import mx.htsoft.spring.boot.microservices.app.item.security.JWTService;
import mx.htsoft.spring.boot.microservices.app.item.security.JWTSERVICES;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UsuarioController {
	
private UsuarioApi UsuarioApi = new UsuarioApi();
	
	@Autowired
	private IUsuario iusuario;
	private IUser_rol iuser;
	private JWTService jwtservice;
	private JWTSERVICES jw;
	private sendToken se;
	
	@GetMapping("/rol/{id}")
	public ResponseEntity<Usuario> getUsuarioRol(@PathVariable("id") String user_rol) {
		Optional<Usuario> tutorialData = iusuario.findById(user_rol);
		Usuario user = tutorialData.get();
		if (user.getUser_rol() != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> Login(@RequestBody Usuario tutorial, sendToken se) {
			Optional<Usuario> usuarioObtenido = iusuario.findById(tutorial.getUser_name());
			Usuario user = usuarioObtenido.get();
			if(usuarioObtenido != null){
				 if(tutorial.getPassword().equals(user.getPassword())){
					     if(tutorial.getTipo_usuario().equals(user.getTipo_usuario())) {
					    	 user.setTipo_usuario("administrador");
					    	 user.setTipo_usuario("supervisor");
					    	 user.getToken();
					     }
					 }
				 return new ResponseEntity<>(HttpStatus.OK);
		     }
			 return new ResponseEntity<>("Requerieres permisos",HttpStatus.UNAUTHORIZED);
	}
	
	
		
       
	@GetMapping("/usuario1")
	public List<Usuario> Usuario(){
		return this.UsuarioApi.GetUnidad(iusuario);
	}
	
	
	
	
	@GetMapping("/usuario")
	public ResponseEntity<List<Usuario>> Usuarios(){
		try {
			List<Usuario> venta = new ArrayList<Usuario>();
			this.iusuario.findAll().forEach(venta::add);
			if(venta.isEmpty()) {
				return new ResponseEntity<>(venta, HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(venta, HttpStatus.OK);
			}catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
	
	@GetMapping("/usuario/{id}")
	public ResponseEntity<Usuario> getUsuarioId(@PathVariable("id") String id) {
		Optional<Usuario> tutorialData = iusuario.findById(id);

		if (tutorialData.isPresent()) {
			return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/usuario")
	public ResponseEntity<Usuario> createUnidad(@RequestBody Usuario tutorial) {
		try {
			Usuario _venta = iusuario.save(tutorial);
			return new ResponseEntity<>(_venta, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<HttpStatus> deleteMedida(@PathVariable("id") String id) {
		try {
			iusuario.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/usuario/{id}")
	public ResponseEntity<Usuario> updateMedida(@PathVariable("id") String id, @RequestBody Usuario tutorial) {
		Optional<Usuario> tutorialData = iusuario.findById(id);

		if (tutorialData.isPresent()) {
			Usuario _tutorial = tutorialData.get();
			_tutorial.setUser_name(tutorial.getUser_name());
			_tutorial.setPassword(tutorial.getPassword());
			_tutorial.setTipo_usuario(tutorial.getTipo_usuario());
			_tutorial.setEnable(tutorial.getEnable());
			_tutorial.setUser_code_bascula(tutorial.getUser_code_bascula());
			_tutorial.setFecha_registro(tutorial.getFecha_registro());
			
			
			return new ResponseEntity<>(iusuario.save(_tutorial), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


}
