//Modelo de la tabla de ejercicios
package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Alumno")
public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_alumno;
	
	@Column(name="Nombre_alumno")
	private String Nombre_alumno;
	
	@Column(name="Apellido_paterno_alumno")
	private String Apellido_paterno_alumno;
	
	@Column(name="Apellido_materno_alumno")
	private String Apellido_materno_alumno;
	
	@Column(name="Correo_alumno")
	private String Correo_alumno;
	
	@Column(name="Contrasena_alumno")
	private String Contrasena_alumno;
	
	public Alumno() {
		
	}
	
	public Alumno(String nombre_alumno, String apellido_paterno_alumno, String apellido_materno_alumno, String correo_alumno, String contrasena_alumno) {
		super();
		Nombre_alumno = nombre_alumno;
		Apellido_paterno_alumno = apellido_paterno_alumno;
		Apellido_materno_alumno = apellido_materno_alumno;
		Correo_alumno = correo_alumno;
		Contrasena_alumno = contrasena_alumno;
	}

	public int getId_alumno() {
		return id_alumno;
	}

	public void setId_alumno(int id_alumno) {
		this.id_alumno = id_alumno;
	}

	public String getNombre_alumno() {
		return Nombre_alumno;
	}

	public void setNombre_alumno(String nombre_alumno) {
		Nombre_alumno = nombre_alumno;
	}

	public String getApellido_paterno_alumno() {
		return Apellido_paterno_alumno;
	}

	public void setApellido_paterno_alumno(String apellido_paterno_alumno) {
		Apellido_paterno_alumno = apellido_paterno_alumno;
	}

	public String getApellido_materno_alumno() {
		return Apellido_materno_alumno;
	}

	public void setApellido_materno_alumno(String apellido_materno_alumno) {
		Apellido_materno_alumno = apellido_materno_alumno;
	}

	public String getCorreo_alumno() {
		return Correo_alumno;
	}

	public void setCorreo_alumno(String correo_alumno) {
		Correo_alumno = correo_alumno;
	}

	public String getContrasena_alumno() {
		return Contrasena_alumno;
	}

	public void setContrasena_alumno(String contrasena_alumno) {
		Contrasena_alumno = contrasena_alumno;
	}
	
	
}