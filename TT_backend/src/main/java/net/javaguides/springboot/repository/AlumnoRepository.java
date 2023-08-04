package net.javaguides.springboot.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{
	@Query(value = "SELECT * from alumno WHERE contrasena_alumno=?1 AND correo_alumno=?2",
			nativeQuery = true)
	public Alumno findByContrasenaAndCorreo(String Contrasena_alumno, String Correo_alumno);
	//con este codigo haces consultas personalizadas, este lo estaba usando para verificar correo y contraseña
}
