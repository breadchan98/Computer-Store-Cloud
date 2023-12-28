package com.example.computers.compparts.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.computers.compparts.domain.ComputerParts;
import com.example.computers.compparts.domain.ComputerParts.Type;

@Component
public class PartsByID implements Converter<String, ComputerParts> {
    
    private Map<String, ComputerParts> compPartsMap = new HashMap<>();

    //No database yet, so this is manually hardcoded
    public PartsByID() {
        compPartsMap.put("AMD7", new ComputerParts("AMD7", "Ryzen 7 5800X", Type.PROCESSOR));
        compPartsMap.put("AMD9", new ComputerParts("AMD9", "Ryzen 9 5950X", Type.PROCESSOR));
        compPartsMap.put("NOCT", new ComputerParts("NOCT", "Noctua NH-U12S", Type.CPUCOOLER));
        compPartsMap.put("KRKN", new ComputerParts("KRKN", "NZXT Kraken Z73", Type.CPUCOOLER));
        compPartsMap.put("GIGA", new ComputerParts("GIGA", "Gigabyte B550 Aorus Pro Wifi", Type.MOTHERBOARD));
        compPartsMap.put("ASUS", new ComputerParts("ASUS", "ASUS TUF GAMING X-570 Plus", Type.MOTHERBOARD));
        compPartsMap.put("CORS", new ComputerParts("CORS", "Corsair Vengeance LPX 32GB DDR4-3200", Type.MEMORY));
        compPartsMap.put("GSKL", new ComputerParts("GSKL", "G-SKILL Trident RGB 64GB DDR4-3600", Type.MEMORY));
        compPartsMap.put("NRTX", new ComputerParts("NRTX", "NVidia GeForce RTX 4080", Type.VIDEOCARD));
        compPartsMap.put("RADN", new ComputerParts("RADN", "AMD Radeon RX 7900 XT", Type.VIDEOCARD));
        compPartsMap.put("CARB", new ComputerParts("CARB", "Corsair Carbide 275R", Type.CASE));
        compPartsMap.put("ELTE", new ComputerParts("ELTE", "NZXT H9 Elite", Type.CASE));
        compPartsMap.put("EVGA", new ComputerParts("EVGA", "EVGA SuperNova 850GT", Type.POWERSUPPLY));
        compPartsMap.put("CORS", new ComputerParts("CORS", "Corsair RM850X", Type.POWERSUPPLY));
    }

    @Override
    public ComputerParts convert(String id) {
        return compPartsMap.get(id);
    }
}
