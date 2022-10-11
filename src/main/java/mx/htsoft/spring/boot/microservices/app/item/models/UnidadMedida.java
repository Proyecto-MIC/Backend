package mx.htsoft.spring.boot.microservices.app.item.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "unidad_medida")
public class UnidadMedida {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id_unidad;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "fecha_registro")
	private Date fecha_registro;
	
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

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public String getCve_sat() {
		return cve_sat;
	}

	public void setCve_sat(String cve_sat) {
		this.cve_sat = cve_sat;
	}
	
	

}
