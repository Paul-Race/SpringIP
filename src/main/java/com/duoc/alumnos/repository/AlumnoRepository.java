package com.duoc.alumnos.repository;

import com.duoc.alumnos.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//El encargado de comunicarse a la bbdd
@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

}
