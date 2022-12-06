package mx.htsoft.spring.boot.microservices.app.item.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "promocion")
public class Promocion {
	
	@Id
	private String id_promo;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "tipo_promo")
	private String tipo_promo;
	
	@Column(name = "fecha_ini")
	private String fecha_ini;
	
	@Column(name = "fecha_fin")
	private String fecha_fin;

	public String getId_promo() {
		return id_promo;
	}

	public void setId_promo(String id_promo) {
		this.id_promo = id_promo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo_promo() {
		return tipo_promo;
	}

	public void setTipo_promo(String tipo_promo) {
		this.tipo_promo = tipo_promo;
	}

	public String getFecha_ini() {
		return fecha_ini;
	}

	public void setFecha_ini(String fecha_ini) {
		this.fecha_ini = fecha_ini;
	}

	public String getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public Promocion(String id_promo, String descripcion, String tipo_promo, String fecha_ini, String fecha_fin) {
		this.id_promo = id_promo;
		this.descripcion = descripcion;
		this.tipo_promo = tipo_promo;
		this.fecha_ini = fecha_ini;
		this.fecha_fin = fecha_fin;
	}
	
	public Promocion() {
		
	}
	
	

}
