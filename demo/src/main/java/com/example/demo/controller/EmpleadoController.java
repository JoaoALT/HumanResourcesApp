package com.example.demo.controller;

import com.example.demo.bd.EmpleadoORM;
import com.example.demo.logica.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {


    @Autowired
    private EmpleadoService service;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmpleadoORM crearEmpleado(@RequestBody EmpleadoORM empleado){
        return service.addEmpleado(empleado);
    }

    @GetMapping
    public List<EmpleadoORM> getAllEmpleados(){
        return service.findAllEmpleados();
    }

    @GetMapping("/{empleadoId}")
    public EmpleadoORM getEmpleadoById(@PathVariable Integer empleadoId){
        return service.getEmpleadoById(empleadoId);
    }

    @GetMapping("/Email/{empleadoEmail}")
    public EmpleadoORM getEmpleadoByEmail(@PathVariable String empleadoEmail){
        return service.getEmpleadoByEmail(empleadoEmail);
    }

    @PutMapping("/actualizar/{empleadoId}")
    public EmpleadoORM updateEmpleado(@RequestBody EmpleadoORM empleado){
        return service.updateEmpleado(empleado);
    }

    @DeleteMapping("/eliminar/{empleadoId}")
    public String deleteEmpleado(@PathVariable Integer empleadoId){
        return service.deleteEmpleado(empleadoId);
    }

}

