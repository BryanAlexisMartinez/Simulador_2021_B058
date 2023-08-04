package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Ejercicio;

@Repository
public interface EjercicioRepository extends JpaRepository<Ejercicio, Integer>{

}
