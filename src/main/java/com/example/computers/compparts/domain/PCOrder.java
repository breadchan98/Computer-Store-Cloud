package com.example.computers.compparts.domain;

import java.util.List;

import org.hibernate.validator.constraints.CreditCardNumber;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import lombok.Data;


@Data
public class PCOrder {

    @NotBlank(message="Name cannot be empty")
    private String customerName;
    
    @NotBlank(message="Stress cannot be empty")
    private String customerStreet;
    
    @NotBlank(message="City cannot be empty")
    private String customerCity;
    
    @NotBlank(message="State cannot be empty")
    private String customerState;

    @NotBlank(message="Zip Code cannot be empty")
    @Size(max=5)
    private String customerZip;
    
    @CreditCardNumber(message="Not a Valid Credit Card Number")
    private String customerCCNum;

    @Digits(integer=3, fraction=0, message="CVV invalid")
    private String customerCCV;

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", message="Must be formatted MM/YY")
    private String customerCCExpiration;

    private List<CustomPC> pcBuild = new ArrayList<>();

    //when addBuild() used, it will be added to pcBuild array list
    public void addBuild (CustomPC customPC) {
        this.pcBuild.add(customPC);
    }
}
