package mx.htsoft.spring.boot.microservices.app.item.controllers;

import java.util.ArrayList;
import java.util.List;

import mx.htsoft.spring.boot.microservices.app.item.interfaze.IDireccionProveedor;
import mx.htsoft.spring.boot.microservices.app.item.models.DireccionProveedor;

public class DireccionProveedorApi {

	public List<DireccionProveedor> GetArticulo(IDireccionProveedor idireccionproveedor){
		List<DireccionProveedor> direccionproveedores = new ArrayList<DireccionProveedor>();
		List<DireccionProveedor> direccionproveedor_result = idireccionproveedor.findAll();
		
		for (DireccionProveedor direccionproveedor : direccionproveedor_result) {
			direccionproveedores.add(direccionproveedor);
		}
		return direccionproveedores;
	}
}
