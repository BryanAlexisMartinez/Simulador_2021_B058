package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User_grupo")
public class User_grupo {
	
	@Id
	@Column(name="Id_grupo")
	private int Id_grupo;
	
	@Column(name="Id_user")
	private int Id_user;
	
	
	
	public User_grupo() {
		
	}

	public User_grupo(int id_grupo, int id_user) {
		super();
		Id_user=id_user;
		Id_grupo = id_grupo;
	}

	public int getId_grupo() {
		return Id_grupo;
	}

	public void setId_grupo(int id_grupo) {
		this.Id_grupo = id_grupo;
	}
	public int getId_user() {
		return Id_user;
	}

	public void setId_user(int id_user) {
		this.Id_user = id_user;
	}
	
}