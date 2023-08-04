package net.javaguides.springboot.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Grupo")
public class Grupo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_grupo;
	
	@Column(name="Nombre_grupo")
	private String Nombre_grupo;
	
	@Column(name="Clave_de_acceso")
	private String Clave_de_acceso;
	
	@ManyToMany(mappedBy="grupos")
	private Set<User> users = new HashSet<>();
	
	public Grupo() {
		
	}

	public Grupo(String nombre_grupo, String clave_de_acceso) {
		super();
		Nombre_grupo=nombre_grupo;
		Clave_de_acceso=clave_de_acceso;
	}

	public int getId_grupo() {
		return id_grupo;
	}

	public void setId_grupo(int id_grupo) {
		this.id_grupo = id_grupo;
	}

	public String getNombre_grupo() {
		return Nombre_grupo;
	}

	public void setNombre_grupo(String nombre_grupo) {
		Nombre_grupo = nombre_grupo;
	}

	public String getClave_de_acceso() {
		return Clave_de_acceso;
	}

	public void setClave_de_acceso(String clave_de_acceso) {
		Clave_de_acceso = clave_de_acceso;
	}

	
	
	

}
