package com.duoc.alumnos.repository;

import com.duoc.alumnos.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AlumnoRepository implements JpaRepository<Alumno, Long> {
}
