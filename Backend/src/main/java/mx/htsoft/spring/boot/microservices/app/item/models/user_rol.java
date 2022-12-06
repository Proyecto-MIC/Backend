package mx.htsoft.spring.boot.microservices.app.item.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_rol")
public class user_rol {
	@Id
	private String user_rol;
	
	@Column(name = "descripcion")
	private String descripcion;

	public String getUser_rol() {
		return user_rol;
	}

	public void setUser_rol(String user_rol) {
		this.user_rol = user_rol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public user_rol(String user_rol, String descripcion) {
		super();
		this.user_rol = user_rol;
		this.descripcion = descripcion;
	}
	
	public user_rol() {
		
	}
	

}
