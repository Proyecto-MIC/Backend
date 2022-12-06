package mx.htsoft.spring.boot.microservices.app.item.controllers;

import java.util.ArrayList;
import java.util.List;

import mx.htsoft.spring.boot.microservices.app.item.interfaze.IVenta;
import mx.htsoft.spring.boot.microservices.app.item.models.venta;

public class VentaApi {
	public List<venta> GetUnidad(IVenta iventa){
		List<venta> ventas = new ArrayList<venta>();
		List<venta> ventas_result = iventa.findAll();
		
		for (venta venta : ventas_result) {
			ventas.add(venta);
		}
		return ventas;
	}
	


}
