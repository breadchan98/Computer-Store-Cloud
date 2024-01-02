package com.example.computers.compparts.jdbctemp;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.computers.compparts.domain.ComputerParts;
import com.example.computers.compparts.database.CompPartsRepo;

@Repository
public class JdbcCompPartsRepo implements CompPartsRepo {
    private JdbcTemplate jdbctemp;
    
    public JdbcCompPartsRepo (JdbcTemplate jdbctemp) {
        this.jdbctemp = jdbctemp;
    }
}
