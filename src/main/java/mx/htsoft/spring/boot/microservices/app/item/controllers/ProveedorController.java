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

}
