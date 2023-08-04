
package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Alumno;
import net.javaguides.springboot.repository.*;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class AlumnoController {

	@Autowired
	private AlumnoRepository alumnoRepository;
	
	//get all
	@GetMapping("/alumnos")
	public List<Alumno> getAllAlumnos(){
		return alumnoRepository.findAll();
	}
	
	//create
	@PostMapping("/alumnos")
	public Alumno createEjercicios(@RequestBody Alumno ejercicio) {
		return alumnoRepository.save(ejercicio);
	}
	
	//get by Id
	@GetMapping("/alumnos/{id_alumno}")
	public ResponseEntity<Alumno> getAlumnoById(@PathVariable int id_alumno) {
		Alumno alumno = alumnoRepository.findById(id_alumno).orElseThrow(() -> new ResourceNotFoundException("El alumno con el id "+ id_alumno + "no existe"));
		return ResponseEntity.ok(alumno);
	}
	
	//get by Id
	@GetMapping("/alumno/{Contrasena_alumno}/{Correo_alumno}")
	public ResponseEntity<Alumno> getAlumnoByContrasena(@PathVariable String Correo_alumno, @PathVariable String Contrasena_alumno) {
		Alumno alumno = alumnoRepository.findByContrasenaAndCorreo(Contrasena_alumno, Correo_alumno);
		return ResponseEntity.ok(alumno);
	}
	
	//update exercise
	@PutMapping("/alumnos/{id_alumno}")
	public ResponseEntity<Alumno> updateAlumno(@PathVariable int id_alumno, @RequestBody Alumno Detallesalumno){
		Alumno alumno = alumnoRepository.findById(id_alumno).orElseThrow(() -> new ResourceNotFoundException("El alumno con el id "+ id_alumno + "no existe"));
		alumno.setNombre_alumno(Detallesalumno.getNombre_alumno());
		alumno.setApellido_paterno_alumno(Detallesalumno.getApellido_paterno_alumno());
		alumno.setApellido_materno_alumno(Detallesalumno.getApellido_materno_alumno());
		alumno.setCorreo_alumno(Detallesalumno.getCorreo_alumno());
		alumno.setContrasena_alumno(Detallesalumno.getContrasena_alumno());
		Alumno actualizado = alumnoRepository.save(alumno);
		return ResponseEntity.ok(actualizado);
	}
	
	//delete exercise
	@DeleteMapping("/alumnos/{id_alumno}")
	public ResponseEntity<Map<String, Boolean>> deleteAlumno(@PathVariable int id_alumno){
		Alumno alumno = alumnoRepository.findById(id_alumno).orElseThrow(() -> new ResourceNotFoundException("El alumno con el id "+ id_alumno + "no existe"));
		
		alumnoRepository.delete(alumno);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
	
	
	
	
}
