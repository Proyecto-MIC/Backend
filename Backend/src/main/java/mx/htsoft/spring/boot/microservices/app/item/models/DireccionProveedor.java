package mx.htsoft.spring.boot.microservices.app.item.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "direccion_proveedor")
public class DireccionProveedor {
	
	@Id
	private String id_proveedor;
	
	@Column(name = "calle")
	private String calle;
	
	@Column(name = "no_int")
	private String no_int;
	
	@Column(name = "no_ext")
	private String no_ext;
	
	@Column(name = "colonia")
	private String colonia;
	
	@Column(name = "localidad")
	private String localidad;
	
	@Column(name = "id_entidad")
	private String id_entidad;
	
	@Column(name = "id_municipio")
	private String id_municipio;
	
	@Column(name = "pais")
	private String pais;
	
	@Column(name = "cod_postal")
	private String cod_postal;

	public String getId_proveedor() {
		return id_proveedor;
	}

	public void setId_proveedor(String id_proveedor) {
		this.id_proveedor = id_proveedor;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNo_int() {
		return no_int;
	}

	public void setNo_int(String no_int) {
		this.no_int = no_int;
	}

	public String getNo_ext() {
		return no_ext;
	}

	public void setNo_ext(String no_ext) {
		this.no_ext = no_ext;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getId_entidad() {
		return id_entidad;
	}

	public void setId_entidad(String id_entidad) {
		this.id_entidad = id_entidad;
	}

	public String getId_municipio() {
		return id_municipio;
	}

	public void setId_municipio(String id_municipio) {
		this.id_municipio = id_municipio;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCod_postal() {
		return cod_postal;
	}

	public void setCod_postal(String cod_postal) {
		this.cod_postal = cod_postal;
	}

	public DireccionProveedor(String id_proveedor, String calle, String no_int, String no_ext, String colonia,
			String localidad, String id_entidad, String id_municipio, String pais, String cod_postal) {
		this.id_proveedor = id_proveedor;
		this.calle = calle;
		this.no_int = no_int;
		this.no_ext = no_ext;
		this.colonia = colonia;
		this.localidad = localidad;
		this.id_entidad = id_entidad;
		this.id_municipio = id_municipio;
		this.pais = pais;
		this.cod_postal = cod_postal;
	}
	
	public DireccionProveedor() {
		
	}
	
	
	
	
	
	
	
}
