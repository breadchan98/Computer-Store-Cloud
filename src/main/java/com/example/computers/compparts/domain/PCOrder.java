package com.example.computers.compparts.domain;

import java.util.List;
import java.util.ArrayList;
import lombok.Data;


@Data
public class PCOrder {
    private String customerName;
    private String customerStreet;
    private String customerCity;
    private String customerState;
    private String customerZip;
    private String customerCCNum;
    private String customerCCV;
    private String customerCCExpiration;

    private List<CustomPC> pcBuild = new ArrayList<>();

    //when addBuild() used, it will be added to pcBuild array list
    public void addBuild (CustomPC customPC) {
        this.pcBuild.add(customPC);
    }
}
