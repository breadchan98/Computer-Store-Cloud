package com.example.computers.compparts.domain;

import lombok.Data;

@Data
public class ComputerParts {
    
    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        PROCESSOR, CPUCOOLER, MOTHERBOARD, MEMORY, VIDEOCARD, CASE, POWERSUPPLY
    }
}
