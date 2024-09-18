package com.example.demo.bd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

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
    private List<String> habilidades;
    private List<String> formacionAcademica;
    private List<String> historialLaboral;

}
