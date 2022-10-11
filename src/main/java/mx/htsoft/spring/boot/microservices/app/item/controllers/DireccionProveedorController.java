package mx.htsoft.spring.boot.microservices.app.item.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import mx.htsoft.spring.boot.microservices.app.item.interfaze.IDireccionProveedor;
import mx.htsoft.spring.boot.microservices.app.item.models.DireccionProveedor;

@CrossOrigin(origins = "http://localhost:8004")
@RestController
@RequestMapping("/api")
public class DireccionProveedorController {
	
private DireccionProveedorApi direccionApi = new DireccionProveedorApi();
	
	@Autowired
	private IDireccionProveedor idireccionproveedor;
	
	@GetMapping("/direccion1")
	public List<DireccionProveedor> direccion1(){
		return this.direccionApi.GetArticulo(idireccionproveedor);
	}
	
	@GetMapping("/direccion")
	public ResponseEntity<List<DireccionProveedor>> direcicon(){
		try {
			List<DireccionProveedor> prueba = new ArrayList<DireccionProveedor>();
			this.idireccionproveedor.findAll().forEach(prueba::add);
			if(prueba.isEmpty()) {
				return new ResponseEntity<>(prueba, HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(prueba, HttpStatus.OK);
			}catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
	
	@GetMapping("/direccion/{id}")
	public ResponseEntity<DireccionProveedor> getDireccionById(@PathVariable("id") String id) {
		Optional<DireccionProveedor> tutorialData = idireccionproveedor.findById(id);

		if (tutorialData.isPresent()) {
			return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
