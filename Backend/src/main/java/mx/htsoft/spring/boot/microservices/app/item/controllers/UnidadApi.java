package mx.htsoft.spring.boot.microservices.app.item.controllers;

import java.util.ArrayList;
import java.util.List;

import mx.htsoft.spring.boot.microservices.app.item.interfaze.IUnidad;
import mx.htsoft.spring.boot.microservices.app.item.models.UnidadMedida;

public class UnidadApi {
	public List<UnidadMedida> GetUnidad(IUnidad iunidad){
		List<UnidadMedida> unidades = new ArrayList<UnidadMedida>();
		List<UnidadMedida> unidades_result = iunidad.findAll();
		
		for (UnidadMedida unidad : unidades_result) {
			unidades.add(unidad);
		}
		return unidades;
	}
	

}
