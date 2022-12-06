package mx.htsoft.spring.boot.microservices.app.item.controllers;

import java.util.ArrayList;
import java.util.List;

import mx.htsoft.spring.boot.microservices.app.item.interfaze.IPromocion;
import mx.htsoft.spring.boot.microservices.app.item.models.Promocion;

public class PromocionApi {
	
	public List<Promocion> GetUnidad(IPromocion ipromocion){
		List<Promocion> unidades = new ArrayList<Promocion>();
		List<Promocion> unidades_result = ipromocion.findAll();
		
		for (Promocion promocion : unidades_result) {
			unidades.add(promocion);
		}
		return unidades;
	}

}
