package mx.htsoft.spring.boot.microservices.app.item.controllers;

import java.util.ArrayList;
import java.util.List;

import mx.htsoft.spring.boot.microservices.app.item.interfaze.IUsuario;
import mx.htsoft.spring.boot.microservices.app.item.models.Usuario;

public class UsuarioApi {
	
	
	public List<Usuario> GetUnidad(IUsuario iventa){
		List<Usuario> ventas = new ArrayList<Usuario>();
		List<Usuario> ventas_result = iventa.findAll();
		
		for (Usuario venta : ventas_result) {
			ventas.add(venta);
		}
		return ventas;
	}

}
