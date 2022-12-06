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
import mx.htsoft.spring.boot.microservices.app.item.interfaze.IUnidad;
import mx.htsoft.spring.boot.microservices.app.item.models.UnidadMedida;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class UnidadController {
private UnidadApi unidadApi = new UnidadApi();
	
	@Autowired
	private IUnidad iunidad;
	
	@GetMapping("/unidad1")
	public List<UnidadMedida> unidad1(){
		return this.unidadApi.GetUnidad(iunidad);
	}
	
	@GetMapping("/unidad")
	public ResponseEntity<List<UnidadMedida>> Unidad(){
		try {
			List<UnidadMedida> prueba = new ArrayList<UnidadMedida>();
			this.iunidad.findAll().forEach(prueba::add);
			if(prueba.isEmpty()) {
				return new ResponseEntity<>(prueba, HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(prueba, HttpStatus.OK);
			}catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
	
	@GetMapping("/unidad/{id}")
	public ResponseEntity<UnidadMedida> getUnidadById(@PathVariable("id") String id) {
		Optional<UnidadMedida> tutorialData = iunidad.findById(id);

		if (tutorialData.isPresent()) {
			return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/unidad")
	public ResponseEntity<UnidadMedida> createUnidad(@RequestBody UnidadMedida tutorial) {
		try {
			UnidadMedida _articulo = iunidad.save(tutorial);
			return new ResponseEntity<>(_articulo, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/unidad/{id}")
	public ResponseEntity<HttpStatus> deleteMedida(@PathVariable("id") String id) {
		try {
			iunidad.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/unidad/{id}")
	public ResponseEntity<UnidadMedida> updateMedida(@PathVariable("id") String id, @RequestBody UnidadMedida tutorial) {
		Optional<UnidadMedida> tutorialData = iunidad.findById(id);

		if (tutorialData.isPresent()) {
			UnidadMedida _tutorial = tutorialData.get();
			_tutorial.setCve_sat(tutorial.getCve_sat());
			_tutorial.setDescripcion(tutorial.getDescripcion());
			_tutorial.setFecha_registro(tutorial.getFecha_registro());
			_tutorial.setId_unidad(tutorial.getId_unidad());
			return new ResponseEntity<>(iunidad.save(_tutorial), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	

}
