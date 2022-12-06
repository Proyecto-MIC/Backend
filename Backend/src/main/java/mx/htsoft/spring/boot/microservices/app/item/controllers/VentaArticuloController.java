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

import mx.htsoft.spring.boot.microservices.app.item.interfaze.IVentaArticulo;
import mx.htsoft.spring.boot.microservices.app.item.models.VentaArticulo;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")


public class VentaArticuloController {
	
private VentaArticuloApi ventaarticuloApi = new VentaArticuloApi();
	
	@Autowired
	private IVentaArticulo iventaarticulo;
	
	@GetMapping("/ventas1")
	public List<VentaArticulo> VentaArticulo(){
		return this.ventaarticuloApi.GetUnidad(iventaarticulo);
	}
	
	@GetMapping("/ventas")
	public ResponseEntity<List<VentaArticulo>> VentasArticulo(){
		try {
			List<VentaArticulo> venta = new ArrayList<VentaArticulo>();
			this.iventaarticulo.findAll().forEach(venta::add);
			if(venta.isEmpty()) {
				return new ResponseEntity<>(venta, HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(venta, HttpStatus.OK);
			}catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
	
	@GetMapping("/ventas/{id}")
	public ResponseEntity<VentaArticulo> getventaById(@PathVariable("id") String id) {
		Optional<VentaArticulo> tutorialData = iventaarticulo.findById(id);

		if (tutorialData.isPresent()) {
			return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/ventas")
	public ResponseEntity<VentaArticulo> createUnidad(@RequestBody VentaArticulo tutorial) {
		try {
			VentaArticulo _venta = iventaarticulo.save(tutorial);
			return new ResponseEntity<>(_venta, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/ventas/{id}")
	public ResponseEntity<HttpStatus> deleteMedida(@PathVariable("id") String id) {
		try {
			iventaarticulo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/ventas/{id}")
	public ResponseEntity<VentaArticulo> updateMedida(@PathVariable("id") String id, @RequestBody VentaArticulo tutorial) {
		Optional<VentaArticulo> tutorialData = iventaarticulo.findById(id);

		if (tutorialData.isPresent()) {
			VentaArticulo _tutorial = tutorialData.get();
			_tutorial.setId_pos(tutorial.getId_pos());
			_tutorial.setId_venta(tutorial.getId_venta());
			_tutorial.setNo_articulo(tutorial.getNo_articulo());
			_tutorial.setCod_barras(tutorial.getCod_barras());
			_tutorial.setUser_code_bascula(tutorial.getUser_code_bascula());
			_tutorial.setCantidad(tutorial.getCantidad());
			_tutorial.setArticulo_ofertado(tutorial.getArticulo_ofertado());
			_tutorial.setPrecio_regular(tutorial.getPrecio_regular());
			_tutorial.setCambio_precio(tutorial.getCambio_precio());
			_tutorial.setIva(tutorial.getIva());
			_tutorial.setPrecio_vta(tutorial.getPrecio_vta());
			_tutorial.setPorcent_desc(tutorial.getPorcent_desc());
			_tutorial.setCant_devuelta(tutorial.getCant_devuelta());
			_tutorial.setUser_name(tutorial.getUser_name());
			_tutorial.setId_promo(tutorial.getId_promo());
			_tutorial.setNo_promo_aplicado(tutorial.getNo_promo_aplicado());
			
			
			return new ResponseEntity<>(iventaarticulo.save(_tutorial), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


}
