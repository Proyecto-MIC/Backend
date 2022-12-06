package mx.htsoft.spring.boot.microservices.app.item.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "unidad_medida")
public class UnidadMedida {
	
	@Id
	private String id_unidad;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "fecha_registro")
	private String fecha_registro;
	
	@Column(name = "cve_sat")
	private String cve_sat;

	public String getId_unidad() {
		return id_unidad;
	}

	public void setId_unidad(String id_unidad) {
		this.id_unidad = id_unidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(String fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public String getCve_sat() {
		return cve_sat;
	}

	public void setCve_sat(String cve_sat) {
		this.cve_sat = cve_sat;
	}

	public UnidadMedida(String id_unidad, String descripcion, String fecha_registro, String cve_sat) {
		this.id_unidad = id_unidad;
		this.descripcion = descripcion;
		this.fecha_registro = fecha_registro;
		this.cve_sat = cve_sat;
	}
	
	public UnidadMedida() {
		
	}
	
	
	
	

}
