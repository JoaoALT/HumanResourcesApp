package com.example.demo.bd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoORM {
    @Id
    private Integer id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private ArrayList<String> habilidades;
    private ArrayList<String> formacionAcademica;
    private ArrayList<String> historialLaboral;

}
