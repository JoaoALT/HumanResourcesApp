package com.example.demo.bd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;
import java.util.ArrayList;

@Document(collection = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoORM {

    @Id
    private Integer id;

    @NotEmpty
    @NotNull(message = "Nombre cannot be null")
    @Size(min = 1,max = 50)
    private String nombre;

    @NotEmpty
    @NotNull(message = "Apellido cannot be null")
    @Size(min = 2,max = 50)
    private String apellido;

    @NotEmpty
    @NotNull(message = "Email cannot be null")
    @Email
    private String email;

    @NotEmpty
    @NotNull(message = "Telefono cannot be null")
    @Size(min = 10, max=10)
    private String telefono;

    private ArrayList<String> habilidades;

    private ArrayList<String> formacionAcademica;

    private ArrayList<String> historialLaboral;

}
