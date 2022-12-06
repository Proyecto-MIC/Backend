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
import mx.htsoft.spring.boot.microservices.app.item.interfaze.IArticulo;
import mx.htsoft.spring.boot.microservices.app.item.models.Articulo;

@CrossOrigin(origins = "*")
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
	
	@PostMapping("/articulo")
	public ResponseEntity<Articulo> createArticulo(@RequestBody Articulo tutorial) {
		try {
			Articulo _articulo = iarticulo.save(tutorial);
			return new ResponseEntity<>(_articulo, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/articulo/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") String id) {
		try {
			iarticulo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/articulo/{id}")
	public ResponseEntity<Articulo> updateArticulo(@PathVariable("id") String id, @RequestBody Articulo tutorial) {
		Optional<Articulo> tutorialData = iarticulo.findById(id);

		if (tutorialData.isPresent()) {
			Articulo _tutorial = tutorialData.get();
			_tutorial.setCod_barras(tutorial.getCod_barras());
			_tutorial.setCod_asociado(tutorial.getCod_asociado());
			_tutorial.setId_clasificacion(tutorial.getId_clasificacion());
			_tutorial.setCod_interno(tutorial.getCod_interno());
			_tutorial.setDescripcion(tutorial.getDescripcion());
			_tutorial.setDescripcion_corta(tutorial.getDescripcion_corta());
			_tutorial.setCantidad_um(tutorial.getCantidad_um());
			_tutorial.setId_unidad(tutorial.getId_unidad());
			_tutorial.setId_proveedor(tutorial.getId_proveedor());
			_tutorial.setPrecio_compra(tutorial.getPrecio_compra());
			_tutorial.setUtilidad(tutorial.getUtilidad());
			_tutorial.setPrecio_venta(tutorial.getPrecio_venta());
			_tutorial.setTipo_articulo(tutorial.getTipo_articulo());
			_tutorial.setStock(tutorial.getStock());
			_tutorial.setStock_min(tutorial.getStock_min());
			_tutorial.setStock_max(tutorial.getStock_max());
			_tutorial.setIva(tutorial.getIva());
			_tutorial.setKit_fecha_ini(tutorial.getKit_fecha_ini());
			_tutorial.setKit_fecha_fin(tutorial.getKit_fecha_fin());
			_tutorial.setArticulo_disponible(tutorial.getArticulo_disponible());
			_tutorial.setKit(tutorial.getKit());
			_tutorial.setFecha_registro(tutorial.getFecha_registro());
			_tutorial.setVisible(tutorial.getVisible());
			_tutorial.setPuntos(tutorial.getPuntos());
			_tutorial.setLast_update_inventory(tutorial.getLast_update_inventory());
			_tutorial.setCve_producto(tutorial.getCve_producto());
			
			return new ResponseEntity<>(iarticulo.save(_tutorial), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	}
	
