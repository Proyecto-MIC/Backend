package mx.htsoft.spring.boot.microservices.app.item.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.htsoft.spring.boot.microservices.app.item.interfaze.IProveedor;
import mx.htsoft.spring.boot.microservices.app.item.models.Proveedor;

@CrossOrigin(origins = "http://localhost:8004")
@RestController
@RequestMapping("/api")
public class ProveedorController {
	
private ProveedorApi proveedorApi = new ProveedorApi();
	
	@Autowired
	private IProveedor iproveedor;
	
	@GetMapping("/proveedor1")
	public List<Proveedor> proveedor1(){
		return this.proveedorApi.GetProveedor(iproveedor);
	}
	
	@GetMapping("/proveedor")
	public ResponseEntity<List<Proveedor>> Articulos(){
		try {
			List<Proveedor> prueba = new ArrayList<Proveedor>();
			this.iproveedor.findAll().forEach(prueba::add);
			if(prueba.isEmpty()) {
				return new ResponseEntity<>(prueba, HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(prueba, HttpStatus.OK);
			}catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
	
	@GetMapping("/proveedor/{id}")
	public ResponseEntity<Proveedor> getProveedorById(@PathVariable("id") String id) {
		Optional<Proveedor> tutorialData = iproveedor.findById(id);

		if (tutorialData.isPresent()) {
			return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/proveedor/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") String id) {
		try {
			iproveedor.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PostMapping("/proveedor")
	public ResponseEntity<Proveedor> createProveedor(@RequestBody Proveedor tutorial) {
		try {
			Proveedor _proveedor = iproveedor.save(tutorial);
			return new ResponseEntity<>(_proveedor, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/proveedor/{id}")
	public ResponseEntity<Proveedor> updateProveedor(@PathVariable("id") String id, @RequestBody Proveedor tutorial) {
		Optional<Proveedor> tutorialData = iproveedor.findById(id);

		if (tutorialData.isPresent()) {
			Proveedor _tutorial = tutorialData.get();
			_tutorial.setId_proveedor(tutorial.getId_proveedor());
			_tutorial.setRfc(tutorial.getRfc());
			_tutorial.setRazon_social(tutorial.getRazon_social());
			_tutorial.setNombre_contacto(tutorial.getNombre_contacto());
			_tutorial.setTel_principal(tutorial.getTel_principal());
			_tutorial.setTel_movil(tutorial.getTel_movil());
			_tutorial.setE_mail(tutorial.getE_mail());
			_tutorial.setEstatus(tutorial.getEstatus());
			_tutorial.setFecha_registro(tutorial.getFecha_registro());
			return new ResponseEntity<>(iproveedor.save(_tutorial), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
