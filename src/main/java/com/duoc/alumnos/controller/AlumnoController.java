package com.duoc.alumnos.controller;

import com.duoc.alumnos.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
