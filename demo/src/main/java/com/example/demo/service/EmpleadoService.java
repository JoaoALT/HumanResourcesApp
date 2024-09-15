package com.example.demo.service;

import com.example.demo.model.Empleado;
import com.example.demo.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository repository;

    public Empleado addEmpleado(Empleado empleado){
        empleado.setId(getNewId(empleado));
        return repository.save(empleado);
    }

    public List<Empleado> findAllEmpleados(){
        return repository.findAll();
    }

    public Empleado getEmpleadoById(Integer EmpleadoId){
        return repository.findById(EmpleadoId).get();
    }

    public Empleado getEmpleadoByEmail(String EmpleadoEmail){
        return repository.findByEmail(EmpleadoEmail);
    }

    public Empleado updateEmpleado(Empleado empleadoRequest){
        Empleado empleadoActual = repository.findById(empleadoRequest.getId()).get();
        empleadoActual.setNombre(empleadoRequest.getNombre());
        empleadoActual.setApellido(empleadoRequest.getNombre());
        empleadoActual.setEmail(empleadoRequest.getEmail());
        empleadoActual.setTelefono(empleadoRequest.getTelefono());
        empleadoActual.setHabilidades(empleadoRequest.getHabilidades());
        empleadoActual.setFormacionAcademica(empleadoRequest.getFormacionAcademica());
        empleadoActual.setHistorialLaboral(empleadoRequest.getHistorialLaboral());
        return repository.save(empleadoActual);
    }

    public String deleteEmpleado(Integer empleadoId){
        repository.deleteById(empleadoId);
        return "Empleado"+ empleadoId +"eliminado exitosamente";
    }

    private Integer getNewId(Empleado newEmployee){
        List<Empleado> listaTemp = findAllEmpleados();

        for (Empleado empleado : listaTemp){
            if (newEmployee.getId().equals(empleado.getId())){
                return (newEmployee.getId()+1);
            }
        }
        return newEmployee.getId();
    }

}
