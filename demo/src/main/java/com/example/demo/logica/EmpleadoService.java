package com.example.demo.logica;

import com.example.demo.bd.EmpleadoORM;
import com.example.demo.bd.EmpleadoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoJPA repository;

    public EmpleadoORM addEmpleado(EmpleadoORM empleado){
        empleado.setId(getNewId(empleado));
        return repository.save(empleado);
    }

    public List<EmpleadoORM> findAllEmpleados(){
        return repository.findAll();
    }

    public EmpleadoORM getEmpleadoById(Integer EmpleadoId){
        return repository.findById(EmpleadoId).get();
    }

    public EmpleadoORM getEmpleadoByEmail(String EmpleadoEmail){
        return repository.findByEmail(EmpleadoEmail);
    }

    public EmpleadoORM updateEmpleado(EmpleadoORM empleadoRequest){
        EmpleadoORM empleadoActual = repository.findById(empleadoRequest.getId()).get();
        empleadoActual.setNombre(empleadoRequest.getNombre());
        empleadoActual.setApellido(empleadoRequest.getApellido());
        empleadoActual.setEmail(empleadoRequest.getEmail());
        empleadoActual.setTelefono(empleadoRequest.getTelefono());
        empleadoActual.setHabilidades(empleadoRequest.getHabilidades());
        empleadoActual.setFormacionAcademica(empleadoRequest.getFormacionAcademica());
        empleadoActual.setHistorialLaboral(empleadoRequest.getHistorialLaboral());
        return repository.save(empleadoActual);
    }

    public String deleteEmpleado(Integer empleadoId){
        repository.deleteById(empleadoId);
        return "Empleado "+ empleadoId +" eliminado exitosamente";
    }

    private Integer getNewId(EmpleadoORM newEmployee){
        List<EmpleadoORM> listaTemp = findAllEmpleados();
        newEmployee.setId(0);
        for (EmpleadoORM empleado : listaTemp){
            if (newEmployee.getId().equals(empleado.getId())){
                int id = newEmployee.getId()+1;
                newEmployee.setId(id);
            }
        }
        return newEmployee.getId();
    }

}
