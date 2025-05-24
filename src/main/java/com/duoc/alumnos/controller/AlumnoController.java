package com.duoc.alumnos.controller;

import com.duoc.alumnos.model.Alumno;
import com.duoc.alumnos.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlumnoController {

    //"El cable" Inyeccion de dependencias
    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("/api/v1/home")
    public String hello() {
        return "Hello World";
    }

    //ResponseEntity Transforma a JSON tiene un serializer dentro
    @GetMapping("/api/v1/alumnos")
    public ResponseEntity<?> getAlumnos() {
        return ResponseEntity.status(200).body(alumnoService.findAll());
    }

    @GetMapping("/api/v1/alumnos/{id}")
    public ResponseEntity<?> getAlumno(@PathVariable Integer id) {
        Alumno alumno = alumnoService.findById(id);

        if (null == alumno) {
            return ResponseEntity.status(404).body("Alumno no encontrado");
        }

        return ResponseEntity.status(200).body(alumnoService.findById(id));
    }

    @DeleteMapping("/api/v1/alumnos/{id}")
    public ResponseEntity<?> deleteAlumno(@PathVariable Integer id) {
        Alumno alumno = alumnoService.findById(id);

        if (null == alumno) {
            return ResponseEntity.status(404).body("Alumno no encontrado");
        }

        alumnoService.delete(id);

        return ResponseEntity.status(200).body("Alumno eliminado");
    }

    //Buscar parametros con el "/buscarCorreo?correo=dfhjskdfh"
    //Puedo pedir multiples parametros, de los cuales el desarrollador puede elegir cuales mandar y cuales no
    @GetMapping("/api/v1/alumnos/buscarCorreo")
    public ResponseEntity<?> buscarAlumnoCorreo(@RequestParam String correo) {
        Alumno alumno = alumnoService.findbyEmail(correo);

        return ResponseEntity.status(200).body(alumno);
    }


    @GetMapping("/api/v1/alumnos/buscarNombres/{nombres}")
    public ResponseEntity<?> buscarAlumnoNombres(@PathVariable String nombres) {
        List<Alumno> alumno = alumnoService.findByNombres(nombres);

        return ResponseEntity.status(200).body(alumno);
    }

    @PostMapping("/api/v1/alumnos")
    public ResponseEntity<?> saveAlumno(@RequestBody Alumno alumno) {
        Alumno alumnoGuardado = alumnoService.save(alumno);

        return ResponseEntity.status(201).body(alumnoGuardado);
    }


}
