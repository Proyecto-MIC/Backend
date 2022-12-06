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

import mx.htsoft.spring.boot.microservices.app.item.interfaze.IPromocion;
import mx.htsoft.spring.boot.microservices.app.item.models.Promocion;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class PromocionController {
private PromocionApi promocionApi = new PromocionApi();
	
	@Autowired
	private IPromocion ipromocion;
	
	@GetMapping("/promocion1")
	public List<Promocion> promocion1(){
		return this.promocionApi.GetUnidad(ipromocion);
	}
	
	@GetMapping("/promocion")
	public ResponseEntity<List<Promocion>> promocion(){
		try {
			List<Promocion> venta = new ArrayList<Promocion>();
			this.ipromocion.findAll().forEach(venta::add);
			if(venta.isEmpty()) {
				return new ResponseEntity<>(venta, HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(venta, HttpStatus.OK);
			}catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
	
	@GetMapping("/promocion/{id}")
	public ResponseEntity<Promocion> getpromocionById(@PathVariable("id") String id) {
		Optional<Promocion> tutorialData = ipromocion.findById(id);

		if (tutorialData.isPresent()) {
			return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/promocion")
	public ResponseEntity<Promocion> createUnidad(@RequestBody Promocion tutorial) {
		try {
			Promocion _venta = ipromocion.save(tutorial);
			return new ResponseEntity<>(_venta, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/promocion/{id}")
	public ResponseEntity<HttpStatus> deleteMedida(@PathVariable("id") String id) {
		try {
			ipromocion.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/promocion/{id}")
	public ResponseEntity<Promocion> updateMedida(@PathVariable("id") String id, @RequestBody Promocion tutorial) {
		Optional<Promocion> tutorialData = ipromocion.findById(id);

		if (tutorialData.isPresent()) {
			Promocion _tutorial = tutorialData.get();
			_tutorial.setId_promo(tutorial.getId_promo());
			_tutorial.setDescripcion(tutorial.getDescripcion());
			_tutorial.setTipo_promo(tutorial.getTipo_promo());
			_tutorial.setFecha_ini(tutorial.getFecha_ini());
			_tutorial.setFecha_fin(tutorial.getFecha_fin());
			
			return new ResponseEntity<>(ipromocion.save(_tutorial), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

}
