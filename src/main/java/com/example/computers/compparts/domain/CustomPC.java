package com.example.computers.compparts.domain;

import java.util.List;
import lombok.Data;

@Data
public class CustomPC {
    private String name;
    private List<ComputerParts> computerpart;
}
