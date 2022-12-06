package mx.htsoft.spring.boot.microservices.app.item.controllers;

import java.util.ArrayList;
import java.util.List;

import mx.htsoft.spring.boot.microservices.app.item.interfaze.IProveedor;
import mx.htsoft.spring.boot.microservices.app.item.models.Proveedor;

public class ProveedorApi {
	
	public List<Proveedor> GetProveedor(IProveedor iproveedor){
		List<Proveedor> proveedores = new ArrayList<Proveedor>();
		List<Proveedor> proveedores_result = iproveedor.findAll();
		
		for (Proveedor proveedor : proveedores_result) {
			proveedores.add(proveedor);
		}
		return proveedores;
	}

}
