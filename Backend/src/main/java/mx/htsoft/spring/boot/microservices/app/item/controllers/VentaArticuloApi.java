package mx.htsoft.spring.boot.microservices.app.item.controllers;

import java.util.ArrayList;
import java.util.List;

import mx.htsoft.spring.boot.microservices.app.item.interfaze.IVentaArticulo;
import mx.htsoft.spring.boot.microservices.app.item.models.VentaArticulo;

public class VentaArticuloApi {
	public List<VentaArticulo> GetUnidad(IVentaArticulo iventa){
		List<VentaArticulo> ventas = new ArrayList<VentaArticulo>();
		List<VentaArticulo> ventas_result = iventa.findAll();
		
		for (VentaArticulo venta : ventas_result) {
			ventas.add(venta);
		}
		return ventas;
	}

}
