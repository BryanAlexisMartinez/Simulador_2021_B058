
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
import net.javaguides.springboot.model.Ejercicio;
import net.javaguides.springboot.repository.*;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EjercicioController {

	@Autowired
	private EjercicioRepository ejercicioRepository;
	
	//get all
	@GetMapping("/ejercicios")
	public List<Ejercicio> getAllEjercicios(){
		return ejercicioRepository.findAll();
	}
	
	//create
	@PostMapping("/ejercicios")
	public Ejercicio createEjercicios(@RequestBody Ejercicio ejercicio) {
		return ejercicioRepository.save(ejercicio);
	}
	
	//get by Id
	@GetMapping("/ejercicios/{id_ejercicio}")
	public ResponseEntity<Ejercicio> getEjercicioById(@PathVariable int id_ejercicio) {
		Ejercicio ejercicio = ejercicioRepository.findById(id_ejercicio).orElseThrow(() -> new ResourceNotFoundException("El ejercicio con el id "+ id_ejercicio + "no existe"));
		return ResponseEntity.ok(ejercicio);
	}
	
	//update exercise
	@PutMapping("/ejercicios/{id_ejercicio}")
	public ResponseEntity<Ejercicio> updateEjercicio(@PathVariable int id_ejercicio, @RequestBody Ejercicio Detallesejercicio){
		Ejercicio ejercicio = ejercicioRepository.findById(id_ejercicio).orElseThrow(() -> new ResourceNotFoundException("El ejercicio con el id "+ id_ejercicio + "no existe"));
		ejercicio.setX1(Detallesejercicio.getX1());
		ejercicio.setSign1(Detallesejercicio.getSign1());
		ejercicio.setY1(Detallesejercicio.getY1());
		ejercicio.setConst1(Detallesejercicio.getConst1());
		ejercicio.setX2(Detallesejercicio.getX2());
		ejercicio.setSign2(Detallesejercicio.getSign2());
		ejercicio.setY2(Detallesejercicio.getY2());
		ejercicio.setConst2(Detallesejercicio.getConst2());
		ejercicio.setAnswerX(Detallesejercicio.getAnswerX());
		ejercicio.setAnswerY(Detallesejercicio.getAnswerY());
		
		Ejercicio actualizado = ejercicioRepository.save(ejercicio);
		return ResponseEntity.ok(actualizado);
	}
	
	//delete exercise
	@DeleteMapping("/ejercicios/{id_ejercicio}")
	public ResponseEntity<Map<String, Boolean>> deleteEjercicio(@PathVariable int id_ejercicio){
		Ejercicio ejercicio = ejercicioRepository.findById(id_ejercicio).orElseThrow(() -> new ResourceNotFoundException("El ejercicio con el id "+ id_ejercicio + "no existe"));
		
		ejercicioRepository.delete(ejercicio);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
	
}

