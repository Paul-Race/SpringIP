package com.duoc.alumnos.service;

import com.duoc.alumnos.model.Alumno;
import com.duoc.alumnos.repository.AlumnoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//Aqui va la logica de negocio
@Service
@Transactional
public class AlumnoService {

    @Autowired
    public AlumnoRepository alumnoRepository;

    //traer todos los alumnos
    public List<Alumno> findAll() {
        return alumnoRepository.findAll();
    };

    //traer un alumno
    public Alumno findById(Integer id) {
        return alumnoRepository.findById(id).orElse(null);
    }

    // Eliminar un alumno
    public void delete(Integer id) {
        alumnoRepository.deleteById(id);
    }

    // metodo para buscar por correo
    public Alumno findbyEmail(String email) {
        return alumnoRepository.findByCorreo(email);
    }

    public List<Alumno> findByNombres(String nombres) {
        return alumnoRepository.findByNombres(nombres);
    }

}
