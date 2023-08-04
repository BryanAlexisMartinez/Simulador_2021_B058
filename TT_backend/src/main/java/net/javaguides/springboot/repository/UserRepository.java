package net.javaguides.springboot.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.User;
import net.javaguides.springboot.model.Grupo;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	@Query(value = "SELECT * from user WHERE password=?1 AND user_email=?2",
			nativeQuery = true)
	public User findByContrasenaAndCorreo(String Password, String Correo);
	//con este codigo haces consultas personalizadas, este lo estaba usando para verificar correo y contraseña
	
	@Query(value = "Select g from User u JOIN u.grupos g WHERE u.id_user = ?1")
	public List<Grupo> findGrupo(int id_user);
	
}
