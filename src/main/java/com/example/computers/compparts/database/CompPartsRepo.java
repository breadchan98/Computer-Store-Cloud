package com.example.computers.compparts.database;

import java.util.Optional;

import com.example.computers.compparts.domain.ComputerParts;

public interface CompPartsRepo {
    Iterable<ComputerParts> findAll();
    Optional<ComputerParts> findById(String id);
    
    ComputerParts save(ComputerParts computerParts);
    
}
