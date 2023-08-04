package net.javaguides.springboot.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_user;
	
	@Column(name="User_type")
	private int Tipo_usuario;
	
	@Column(name="Username")
	private String Nombre;
	
	@Column(name="Last_name")
	private String Apellido_paterno;
	
	@Column(name="Mothers_last_name")
	private String Apellido_materno;
	
	@Column(name="User_email")
	private String Correo;
	
	@Column(name="Password")
	private String Contrasena;
	
	@Column(name="Security_question")
	private int Pregunta;
	
	@Column(name="Answer_security_question")
	private String Respuesta;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_grupos",
	joinColumns = { @JoinColumn(name = "id_user")},
	inverseJoinColumns= {@JoinColumn(name="id_grupo")})
	private Set<Grupo> grupos = new HashSet<>();
	
	
	
	public User() {
		
	}

	public User(int tipo_usuario, String nombre, String apellido_paterno, String apellido_materno, String correo,
			String contrasena, int pregunta, String respuesta) {
		super();
		Tipo_usuario = tipo_usuario;
		Nombre = nombre;
		Apellido_paterno = apellido_paterno;
		Apellido_materno = apellido_materno;
		Correo = correo;
		Contrasena = contrasena;
		Pregunta = pregunta;
		Respuesta = respuesta;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public int getTipo_usuario() {
		return Tipo_usuario;
	}

	public void setTipo_usuario(int tipo_usuario) {
		Tipo_usuario = tipo_usuario;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido_paterno() {
		return Apellido_paterno;
	}

	public void setApellido_paterno(String apellido_paterno) {
		Apellido_paterno = apellido_paterno;
	}

	public String getApellido_materno() {
		return Apellido_materno;
	}

	public void setApellido_materno(String apellido_materno) {
		Apellido_materno = apellido_materno;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}

	public String getContrasena() {
		return Contrasena;
	}

	public void setContrasena(String contrasena) {
		Contrasena = contrasena;
	}

	public int getPregunta() {
		return Pregunta;
	}

	public void setPregunta(int pregunta) {
		Pregunta = pregunta;
	}

	public String getRespuesta() {
		return Respuesta;
	}

	public void setRespuesta(String respuesta) {
		Respuesta = respuesta;
	}
	
	

}
