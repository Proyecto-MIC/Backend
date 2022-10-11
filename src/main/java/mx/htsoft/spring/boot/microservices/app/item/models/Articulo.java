package mx.htsoft.spring.boot.microservices.app.item.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "articulo")
public class Articulo {
   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String cod_barras;
	
	@Column(name = "cod_asociado")
	private String cod_asociado;
	
	@Column(name = "id_clasificacion")
	private int id_clasificacion;
	
	@Column(name = "cod_interno")
	private String cod_interno;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "descripcion_corta")
	private String descripcion_corta;
	
	@Column(name = "cantidad_um")
	private float cantidad_um;
	
	@Column(name = "id_unidad")
	private String id_unidad;
	
	@Column(name = "id_proveedor")
	private String id_proveedor;
	
	@Column(name = "precio_compra")
	private float precio_compra;
	
	@Column(name = "utilidad")
	private float utilidad;
	
	@Column(name = "precio_venta")
	private float precio_venta;
	
	@Column(name = "tipo_articulo")
	private String tipo_articulo;
	
	@Column(name = "stock")
	private float stock;
	
	@Column(name = "stock_min")
	private float stock_min;
	
	@Column(name = "stock_max")
	private float stock_max;
	
	@Column(name = "iva")
	private float iva;
	
	@Column(name = "kit_fecha_ini")
	private Date kit_fecha_ini;
	
	@Column(name = "kit_fecha_fin")
	private Date kit_fecha_fin;
	
	@Column(name = "articulo_disponible")
	private float articulo_disponible;
	
	@Column(name = "kit")
	private float kit;
	
	@Column(name = "fecha_registro")
	private Date fecha_registro;
	
	@Column(name = "visible")
	private float visible;
	
	@Column(name = "puntos")
	private float puntos;
	
	@Column(name = "last_update_inventory")
	private Date last_update_inventory;
	
	@Column(name = "cve_producto")
	private String cve_producto;

	public String getCod_barras() {
		return cod_barras;
	}

	public void setCod_barras(String cod_barras) {
		this.cod_barras = cod_barras;
	}

	public String getCod_asociado() {
		return cod_asociado;
	}

	public void setCod_asociado(String cod_asociado) {
		this.cod_asociado = cod_asociado;
	}

	public int getId_clasificacion() {
		return id_clasificacion;
	}

	public void setId_clasificacion(int id_clasificacion) {
		this.id_clasificacion = id_clasificacion;
	}

	public String getCod_interno() {
		return cod_interno;
	}

	public void setCod_interno(String cod_interno) {
		this.cod_interno = cod_interno;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion_corta() {
		return descripcion_corta;
	}

	public void setDescripcion_corta(String descripcion_corta) {
		this.descripcion_corta = descripcion_corta;
	}

	public float getCantidad_um() {
		return cantidad_um;
	}

	public void setCantidad_um(float cantidad_um) {
		this.cantidad_um = cantidad_um;
	}

	
	
	public String getId_unidad() {
		return id_unidad;
	}

	public void setId_unidad(String id_unidad) {
		this.id_unidad = id_unidad;
	}

	public String getId_proveedor() {
		return id_proveedor;
	}

	public void setId_proveedor(String id_proveedor) {
		this.id_proveedor = id_proveedor;
	}
	
	
	

	public float getPrecio_compra() {
		return precio_compra;
	}

	public void setPrecio_compra(float precio_compra) {
		this.precio_compra = precio_compra;
	}

	public float getUtilidad() {
		return utilidad;
	}

	public void setUtilidad(float utilidad) {
		this.utilidad = utilidad;
	}

	public float getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(float precio_venta) {
		this.precio_venta = precio_venta;
	}

	public String getTipo_articulo() {
		return tipo_articulo;
	}

	public void setTipo_articulo(String tipo_articulo) {
		this.tipo_articulo = tipo_articulo;
	}

	public float getStock() {
		return stock;
	}

	public void setStock(float stock) {
		this.stock = stock;
	}

	public float getStock_min() {
		return stock_min;
	}

	public void setStock_min(float stock_min) {
		this.stock_min = stock_min;
	}

	public float getStock_max() {
		return stock_max;
	}

	public void setStock_max(float stock_max) {
		this.stock_max = stock_max;
	}

	public float getIva() {
		return iva;
	}

	public void setIva(float iva) {
		this.iva = iva;
	}

	public Date getKit_fecha_ini() {
		return kit_fecha_ini;
	}

	public void setKit_fecha_ini(Date kit_fecha_ini) {
		this.kit_fecha_ini = kit_fecha_ini;
	}

	public Date getKit_fecha_fin() {
		return kit_fecha_fin;
	}

	public void setKit_fecha_fin(Date kit_fecha_fin) {
		this.kit_fecha_fin = kit_fecha_fin;
	}

	public float getArticulo_disponible() {
		return articulo_disponible;
	}

	public void setArticulo_disponible(float articulo_disponible) {
		this.articulo_disponible = articulo_disponible;
	}

	public float getKit() {
		return kit;
	}

	public void setKit(float kit) {
		this.kit = kit;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public float getVisible() {
		return visible;
	}

	public void setVisible(float visible) {
		this.visible = visible;
	}

	public float getPuntos() {
		return puntos;
	}

	public void setPuntos(float puntos) {
		this.puntos = puntos;
	}

	public Date getLast_update_inventory() {
		return last_update_inventory;
	}

	public void setLast_update_inventory(Date last_update_inventory) {
		this.last_update_inventory = last_update_inventory;
	}

	public String getCve_producto() {
		return cve_producto;
	}

	public void setCve_producto(String cve_producto) {
		this.cve_producto = cve_producto;
	}
	
	
	
	
}
