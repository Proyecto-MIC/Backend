package mx.htsoft.spring.boot.microservices.app.item.controllers;
import java.util.ArrayList;
import java.util.List;
import mx.htsoft.spring.boot.microservices.app.item.interfaze.IUser_rol;
import mx.htsoft.spring.boot.microservices.app.item.models.user_rol;
public class RolApi {
	public List<user_rol> GetUnidad(IUser_rol iunidad){
		List<user_rol> unidades = new ArrayList<user_rol>();
		List<user_rol> unidades_result = iunidad.findAll();
		
		for (user_rol unidad : unidades_result) {
			unidades.add(unidad);
		}
		return unidades;
	}
	
}
