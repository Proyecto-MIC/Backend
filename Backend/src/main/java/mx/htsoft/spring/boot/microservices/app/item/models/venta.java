package mx.htsoft.spring.boot.microservices.app.item.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "venta")
public class venta {
	
		@Id
		private int id_pos;
		
		@Column(name = "id_venta")
		private String id_venta;
		
		@Column(name = "vendedor")
		private String vendedor;
		
		@Column(name = "folio")
		private Long folio;
		
		@Column(name = "fecha_venta")
		private Date fecha_venta;
		
		@Column(name = "total_vendido")
		private String total_vendido;
		
		@Column(name = "pago_efectivo")
		private String pago_efectivo;
		
		@Column(name = "pago_cheque")
		private String pago_cheque;
		
		@Column(name = "pago_vales")
		private String pago_vales;
		
		@Column(name = "pago_tc")
		private String pago_tc;
		
		@Column(name = "supervisor")
		private String supervisor;
		
		@Column(name = "upload")
		private String upload;
		
		@Column(name = "num_registros")
		private String num_registros;

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

		public String getVendedor() {
			return vendedor;
		}

		public void setVendedor(String vendedor) {
			this.vendedor = vendedor;
		}

		public Long getFolio() {
			return folio;
		}

		public void setFolio(Long folio) {
			this.folio = folio;
		}

		public Date getFecha_venta() {
			return fecha_venta;
		}

		public void setFecha_venta(Date fecha_venta) {
			this.fecha_venta = fecha_venta;
		}

		public String getTotal_vendido() {
			return total_vendido;
		}

		public void setTotal_vendido(String total_vendido) {
			this.total_vendido = total_vendido;
		}

		public String getPago_efectivo() {
			return pago_efectivo;
		}

		public void setPago_efectivo(String pago_efectivo) {
			this.pago_efectivo = pago_efectivo;
		}

		public String getPago_cheque() {
			return pago_cheque;
		}

		public void setPago_cheque(String pago_cheque) {
			this.pago_cheque = pago_cheque;
		}

		public String getPago_vales() {
			return pago_vales;
		}

		public void setPago_vales(String pago_vales) {
			this.pago_vales = pago_vales;
		}

		public String getPago_tc() {
			return pago_tc;
		}

		public void setPago_tc(String pago_tc) {
			this.pago_tc = pago_tc;
		}

		public String getSupervisor() {
			return supervisor;
		}

		public void setSupervisor(String supervisor) {
			this.supervisor = supervisor;
		}

		public String getUpload() {
			return upload;
		}

		public void setUpload(String upload) {
			this.upload = upload;
		}

		public String getNum_registros() {
			return num_registros;
		}

		public void setNum_registros(String num_registros) {
			this.num_registros = num_registros;
		}

		public venta(int id_pos, String id_venta, String vendedor, Long folio, Date fecha_venta,
				String total_vendido, String pago_efectivo, String pago_cheque, String pago_vales, String pago_tc,
				String supervisor, String upload, String num_registros) {
			
			this.id_pos = id_pos;
			this.id_venta = id_venta;
			this.vendedor = vendedor;
			this.folio = folio;
			this.fecha_venta = fecha_venta;
			this.total_vendido = total_vendido;
			this.pago_efectivo = pago_efectivo;
			this.pago_cheque = pago_cheque;
			this.pago_vales = pago_vales;
			this.pago_tc = pago_tc;
			this.supervisor = supervisor;
			this.upload = upload;
			this.num_registros = num_registros;
		}
		
		
		public venta() {
		
		}
		
}
