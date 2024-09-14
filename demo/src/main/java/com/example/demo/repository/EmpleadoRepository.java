package com.example.demo.repository;

import com.example.demo.model.Empleado;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface EmpleadoRepository extends MongoRepository<Empleado,Integer> {

    @Query("{EmpleadoEmail: ?0 }")
    Empleado findByEmail(String EmpleadoEmail);

}
