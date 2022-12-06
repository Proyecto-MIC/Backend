package mx.htsoft.spring.boot.microservices.app.item.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")

public class Usuario {
	
	@Id
	private String user_name;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "tipo_usuario")
	private String tipo_usuario;
	
	@Column(name = "enable")
	private String enable;
	
	@Column(name = "user_code_bascula")
	private String user_code_bascula ;
	
	@Column(name = "fecha_registro")
	private String fecha_registro;
	
	@Column(name = "id_rol")
	private int id_rol;
	
	@Column(name = "Token")
	private String Token;
	
	@Column(name = "user_rol")
	private String user_rol;

	public String getUser_rol() {
		return user_rol;
	}

	public void setUser_rol(String user_rol) {
		this.user_rol = user_rol;
	}

	public String getToken() {
		return Token;
	}

	public void setToken(String token) {
		Token = token;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipo_usuario() {
		return tipo_usuario;
	}

	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public String getUser_code_bascula() {
		return user_code_bascula;
	}

	public void setUser_code_bascula(String user_code_bascula) {
		this.user_code_bascula = user_code_bascula;
	}

	public String getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(String fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	
	public int getId_rol() {
		return id_rol;
	}

	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}
	

	public Usuario(String user_name, String password, String tipo_usuario, String enable, String user_code_bascula,
			String fecha_registro, int id_rol, String Token, String user_rol) {
		super();
		this.user_name = user_name;
		this.password = password;
		this.tipo_usuario = tipo_usuario;
		this.enable = enable;
		this.user_code_bascula = user_code_bascula;
		this.fecha_registro = fecha_registro;
		this.id_rol = id_rol;
		this.Token = Token;
		this.user_rol = user_rol;
	}
	
	public Usuario() {
	}

}
