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
import mx.htsoft.spring.boot.microservices.app.item.interfaze.IUnidad;
import mx.htsoft.spring.boot.microservices.app.item.models.UnidadMedida;

@CrossOrigin(origins = "http://localhost:8004")
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

}
