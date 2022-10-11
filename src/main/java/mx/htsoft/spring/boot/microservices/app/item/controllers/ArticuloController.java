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
import mx.htsoft.spring.boot.microservices.app.item.interfaze.IArticulo;
import mx.htsoft.spring.boot.microservices.app.item.models.Articulo;

@CrossOrigin(origins = "http://localhost:8004")
@RestController
@RequestMapping("/api")
public class ArticuloController {
	
	private ArticuloApi articuloApi = new ArticuloApi();
	
	@Autowired
	private IArticulo iarticulo;
	
	@GetMapping("/articulo1")
	public List<Articulo> articulos1(){
		return this.articuloApi.GetArticulo(iarticulo);
	}
	
	@GetMapping("/articulo")
	public ResponseEntity<List<Articulo>> Articulos(){
		try {
			List<Articulo> prueba = new ArrayList<Articulo>();
			this.iarticulo.findAll().forEach(prueba::add);
			if(prueba.isEmpty()) {
				return new ResponseEntity<>(prueba, HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(prueba, HttpStatus.OK);
			}catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
	
	@GetMapping("/articulo/{id}")
	public ResponseEntity<Articulo> getArticuloById(@PathVariable("id") String id) {
		Optional<Articulo> tutorialData = iarticulo.findById(id);

		if (tutorialData.isPresent()) {
			return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	}
	
