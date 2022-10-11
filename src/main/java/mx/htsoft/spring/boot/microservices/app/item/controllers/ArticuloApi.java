package mx.htsoft.spring.boot.microservices.app.item.controllers;

import java.util.ArrayList;
import java.util.List;


import mx.htsoft.spring.boot.microservices.app.item.interfaze.IArticulo;
import mx.htsoft.spring.boot.microservices.app.item.models.Articulo;

public class ArticuloApi  {

	public List<Articulo> GetArticulo(IArticulo iarticulo){
		List<Articulo> articulos = new ArrayList<Articulo>();
		List<Articulo> articulos_result = iarticulo.findAll();
		
		for (Articulo articulo : articulos_result) {
			articulos.add(articulo);
		}
		return articulos;
	}
}
