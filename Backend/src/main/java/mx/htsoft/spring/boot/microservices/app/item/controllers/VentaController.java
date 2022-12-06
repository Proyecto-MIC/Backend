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

import mx.htsoft.spring.boot.microservices.app.item.interfaze.IVenta;
import mx.htsoft.spring.boot.microservices.app.item.models.venta;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")

public class VentaController {
private VentaApi ventaApi = new VentaApi();
	
	@Autowired
	private IVenta iventa;
	
	@GetMapping("/venta1")
	public List<venta> venta1(){
		return this.ventaApi.GetUnidad(iventa);
	}
	
	@GetMapping("/venta")
	public ResponseEntity<List<venta>> venta(){
		try {
			List<venta> venta = new ArrayList<venta>();
			this.iventa.findAll().forEach(venta::add);
			if(venta.isEmpty()) {
				return new ResponseEntity<>(venta, HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(venta, HttpStatus.OK);
			}catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
	
	@GetMapping("/venta/{id}")
	public ResponseEntity<venta> getventaById(@PathVariable("id") String id) {
		Optional<venta> tutorialData = iventa.findById(id);

		if (tutorialData.isPresent()) {
			return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/venta")
	public ResponseEntity<venta> createVenta(@RequestBody venta tutorial) {
		try {
			venta _venta = iventa.save(tutorial);
			return new ResponseEntity<>(_venta, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/venta/{id}")
	public ResponseEntity<HttpStatus> deleteMedida(@PathVariable("id") String id) {
		try {
			iventa.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/venta/{id}")
	public ResponseEntity<venta> updateMedida(@PathVariable("id") String id, @RequestBody venta tutorial) {
		Optional<venta> tutorialData = iventa.findById(id);

		if (tutorialData.isPresent()) {
			venta _tutorial = tutorialData.get();
			_tutorial.setId_pos(tutorial.getId_pos());
			_tutorial.setId_venta(tutorial.getId_venta());
			_tutorial.setVendedor(tutorial.getVendedor());
			_tutorial.setFolio(tutorial.getFolio());
			_tutorial.setFecha_venta(tutorial.getFecha_venta());
			_tutorial.setTotal_vendido(tutorial.getTotal_vendido());
			_tutorial.setPago_efectivo(tutorial.getPago_efectivo());
			_tutorial.setPago_cheque(tutorial.getPago_cheque());
			_tutorial.setPago_vales(tutorial.getPago_vales());
			_tutorial.setPago_tc(tutorial.getPago_tc());
			_tutorial.setSupervisor(tutorial.getSupervisor());
			_tutorial.setUpload(tutorial.getUpload());
			_tutorial.setNum_registros(tutorial.getNum_registros());
			
			
			return new ResponseEntity<>(iventa.save(_tutorial), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	
}
