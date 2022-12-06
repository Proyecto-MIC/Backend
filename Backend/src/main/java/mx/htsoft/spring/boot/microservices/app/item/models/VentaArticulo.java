package mx.htsoft.spring.boot.microservices.app.item.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "venta_articulo")

public class VentaArticulo {
	
	@Id
	private int id_pos;
	
	@Column(name = "id_venta")
	private String id_venta;
	
	@Column(name = "no_articulo")
	private String no_articulo;
	
	@Column(name = "cod_barras")
	private String cod_barras;
	
	@Column(name = "user_code_bascula")
	private Long user_code_bascula;
	
	@Column(name = "cantidad")
	private int cantidad;
	
	@Column(name = "articulo_ofertado")
	private Boolean articulo_ofertado;
	
	@Column(name = "precio_regular")
	private String  precio_regular;
	
	@Column(name = "cambio_precio")
	private Boolean  cambio_precio;
	
	@Column(name = "iva")
	private int iva;
	
	@Column(name = "precio_vta")
	private int  precio_vta;
	
	@Column(name = "porcent_desc")
	private int  porcent_desc;
	
	@Column(name = "cant_devuelta")
	private int  cant_devuelta;
	
	@Column(name = "user_name")
	private String user_name;
	
	@Column(name = "id_promo")
	private String id_promo;
	
	@Column(name = "no_promo_aplicado")
	private Long no_promo_aplicado;

	public int getId_pos() {
		return id_pos;
	}

	public void setId_pos(int id_pos) {
		this.id_pos = id_pos;
	}

	public String getId_venta() {
		return id_venta;
	}

	public void setId_venta(String id_venta) {
		this.id_venta = id_venta;
	}

	public String getNo_articulo() {
		return no_articulo;
	}

	public void setNo_articulo(String no_articulo) {
		this.no_articulo = no_articulo;
	}

	public String getCod_barras() {
		return cod_barras;
	}

	public void setCod_barras(String cod_barras) {
		this.cod_barras = cod_barras;
	}

	public Long getUser_code_bascula() {
		return user_code_bascula;
	}

	public void setUser_code_bascula(Long user_code_bascula) {
		this.user_code_bascula = user_code_bascula;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Boolean getArticulo_ofertado() {
		return articulo_ofertado;
	}

	public void setArticulo_ofertado(Boolean articulo_ofertado) {
		this.articulo_ofertado = articulo_ofertado;
	}

	public String getPrecio_regular() {
		return precio_regular;
	}

	public void setPrecio_regular(String precio_regular) {
		this.precio_regular = precio_regular;
	}

	public Boolean getCambio_precio() {
		return cambio_precio;
	}

	public void setCambio_precio(Boolean cambio_precio) {
		this.cambio_precio = cambio_precio;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	public int getPrecio_vta() {
		return precio_vta;
	}

	public void setPrecio_vta(int precio_vta) {
		this.precio_vta = precio_vta;
	}

	public int getPorcent_desc() {
		return porcent_desc;
	}

	public void setPorcent_desc(int porcent_desc) {
		this.porcent_desc = porcent_desc;
	}

	public int getCant_devuelta() {
		return cant_devuelta;
	}

	public void setCant_devuelta(int cant_devuelta) {
		this.cant_devuelta = cant_devuelta;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getId_promo() {
		return id_promo;
	}

	public void setId_promo(String id_promo) {
		this.id_promo = id_promo;
	}

	public Long getNo_promo_aplicado() {
		return no_promo_aplicado;
	}

	public void setNo_promo_aplicado(Long no_promo_aplicado) {
		this.no_promo_aplicado = no_promo_aplicado;
	}

	public VentaArticulo(int id_pos, String id_venta, String no_articulo, String cod_barras, Long user_code_bascula,
			int cantidad, Boolean articulo_ofertado, String precio_regular, Boolean cambio_precio, int iva,
			int precio_vta, int porcent_desc, int cant_devuelta, String user_name, String id_promo,
			Long no_promo_aplicado) {
		this.id_pos = id_pos;
		this.id_venta = id_venta;
		this.no_articulo = no_articulo;
		this.cod_barras = cod_barras;
		this.user_code_bascula = user_code_bascula;
		this.cantidad = cantidad;
		this.articulo_ofertado = articulo_ofertado;
		this.precio_regular = precio_regular;
		this.cambio_precio = cambio_precio;
		this.iva = iva;
		this.precio_vta = precio_vta;
		this.porcent_desc = porcent_desc;
		this.cant_devuelta = cant_devuelta;
		this.user_name = user_name;
		this.id_promo = id_promo;
		this.no_promo_aplicado = no_promo_aplicado;
		
	}
	
	public VentaArticulo() {
		
	}
	
	
	

	
}
