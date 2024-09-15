package com.example.demo.controller;

import com.example.demo.model.Empleado;
import com.example.demo.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class TaskController {


    @Autowired
    private EmpleadoService service;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Empleado crearEmpleado(@RequestBody Empleado empleado){
        return service.addEmpleado(empleado);
    }

    @GetMapping
    public List<Empleado> getAllEmpleados(){
        return service.findAllEmpleados();
    }

    @GetMapping("/{empleadoId}")
    public Empleado getEmpleadoById(@PathVariable Integer empleadoId){
        return service.getEmpleadoById(empleadoId);
    }

    @GetMapping("/Email/{empleadoEmail}")
    public Empleado getEmpleadoByEmail(@PathVariable String empleadoEmail){
        return service.getEmpleadoByEmail(empleadoEmail);
    }

    @PutMapping
    public Empleado updateEmpleado(@RequestBody Empleado empleado){
        return service.updateEmpleado(empleado);
    }

    @DeleteMapping("/eliminar/{empleadoId}")
    public String deleteEmpleado(@PathVariable Integer empleadoId){
        return service.deleteEmpleado(empleadoId);
    }

}

