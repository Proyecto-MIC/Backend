package mx.htsoft.spring.boot.microservices.app.item.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proveedor")
public class Proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id_proveedor;
	
	@Column(name = "rfc")
	private String rfc;
	
	@Column(name = "razon_social")
	private String razon_social;
	
	@Column(name = "nombre_contacto")
	private String nombre_contacto;
	
	@Column(name = "tel_principal")
	private String tel_principal;
	
	@Column(name = "tel_movil")
	private String tel_movil;
	
	@Column(name = "e_mail")
	private String e_mail;
	
	@Column(name = "estatus")
	private String estatus;
	
	@Column(name = "fecha_registro")
	private Date fecha_registro;

	public String getId_proveedor() {
		return id_proveedor;
	}

	public void setId_proveedor(String id_proveedor) {
		this.id_proveedor = id_proveedor;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public String getNombre_contacto() {
		return nombre_contacto;
	}

	public void setNombre_contacto(String nombre_contacto) {
		this.nombre_contacto = nombre_contacto;
	}

	public String getTel_principal() {
		return tel_principal;
	}

	public void setTel_principal(String tel_principal) {
		this.tel_principal = tel_principal;
	}

	public String getTel_movil() {
		return tel_movil;
	}

	public void setTel_movil(String tel_movil) {
		this.tel_movil = tel_movil;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	
	
	
	
}
