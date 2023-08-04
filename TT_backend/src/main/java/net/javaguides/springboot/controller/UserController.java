
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
import net.javaguides.springboot.model.Grupo;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.*;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	//get all
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	//create
	@PostMapping("/users")
	public User createUsers(@RequestBody User usuario) {
		return userRepository.save(usuario);
	}
	
	//get by Id
	@GetMapping("/users/{id_user}")
	public ResponseEntity<User> getUserById(@PathVariable int id_user) {
		User usuario = userRepository.findById(id_user).orElseThrow(() -> new ResourceNotFoundException("El alumno con el id "+ id_user + "no existe"));
		return ResponseEntity.ok(usuario);
	}
	
	//get by Id
	@GetMapping("/user/{Contrasena}/{Correo}")
	public ResponseEntity<User> getUserByContrasena( @PathVariable String Contrasena,@PathVariable String Correo) {
		User usuario = userRepository.findByContrasenaAndCorreo(Contrasena, Correo);
		return ResponseEntity.ok(usuario);
	}
	
	//update exercise
	@PutMapping("/users/{id_user}")
	public ResponseEntity<User> updateUser(@PathVariable int id_user, @RequestBody User Detalles){
		User usuario = userRepository.findById(id_user).orElseThrow(() -> new ResourceNotFoundException("El alumno con el id "+ id_user + "no existe"));
		usuario.setNombre(Detalles.getNombre());
		usuario.setApellido_paterno(Detalles.getApellido_paterno());
		usuario.setApellido_materno(Detalles.getApellido_materno());
		usuario.setCorreo(Detalles.getCorreo());
		usuario.setContrasena(Detalles.getContrasena());
		User actualizado = userRepository.save(usuario);
		return ResponseEntity.ok(actualizado);
	}
	
	//delete exercise
	@DeleteMapping("/users/{id_user}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable int id_user){
		User usuario = userRepository.findById(id_user).orElseThrow(() -> new ResourceNotFoundException("El alumno con el id "+ id_user + "no existe"));
		
		userRepository.delete(usuario);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping("/user/grupos/{id_user}")
	public ResponseEntity<List<Grupo>> getUserGrupo(@PathVariable int id_user) {
		List<Grupo> grupo = userRepository.findGrupo(id_user);
		return ResponseEntity.ok(grupo);
	}
	
	
	
}
