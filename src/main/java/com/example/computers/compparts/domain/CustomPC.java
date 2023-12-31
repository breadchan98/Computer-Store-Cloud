package com.example.computers.compparts.domain;

import java.util.Date;
import java.util.List;

//Bean Validation API
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class CustomPC {

    private Long id;
    private Date creationDate = new Date();
    
    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long") // constraints
    private String name;

    @NotNull
    private List<ComputerParts> computerpart;
}
