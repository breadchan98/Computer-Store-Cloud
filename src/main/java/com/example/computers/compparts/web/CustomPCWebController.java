package com.example.computers.compparts.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;
import com.example.computers.compparts.domain.ComputerParts;
import com.example.computers.compparts.domain.CustomPC;
import com.example.computers.compparts.domain.ComputerParts.Type;
import com.example.computers.compparts.domain.PCOrder;
import org.springframework.web.bind.annotation.RequestBody;




@Slf4j //used for logging frameworks without needing to code
@Controller
@RequestMapping("/create")
@SessionAttributes("customPCOrder")
public class CustomPCWebController {
    
    @ModelAttribute
    public void addCustomPartsToModel (Model model) {
        List<ComputerParts> computerpart = Arrays.asList(
            new ComputerParts("AMD7", "Ryzen 7 5800X", Type.PROCESSOR),
            new ComputerParts("AMD9", "Ryzen 9 5950X", Type.PROCESSOR),
            new ComputerParts("NOCT", "Noctua NH-U12S", Type.CPUCOOLER),
            new ComputerParts("KRKN", "NZXT Kraken Z73", Type.CPUCOOLER),
            new ComputerParts("GIGA", "Gigabyte B550 Aorus Pro Wifi", Type.MOTHERBOARD),
            new ComputerParts("ASUS", "ASUS TUF GAMING X-570 Plus", Type.MOTHERBOARD),
            new ComputerParts("CORS", "Corsair Vengeance LPX 32GB DDR4-3200", Type.MEMORY),
            new ComputerParts("GSKL", "G-SKILL Trident RGB 64GB DDR4-3600", Type.MEMORY),
            new ComputerParts("NRTX", "NVidia GeForce RTX 4080", Type.VIDEOCARD),
            new ComputerParts("RADN", "AMD Radeon RX 7900 XT", Type.VIDEOCARD),
            new ComputerParts("CARB", "Corsair Carbide 275R", Type.CASE),
            new ComputerParts("ELTE", "NZXT H9 Elite", Type.CASE),
            new ComputerParts("EVGA", "EVGA SuperNova 850GT", Type.POWERSUPPLY),
            new ComputerParts("CORS", "Corsair RM850X", Type.POWERSUPPLY)
        );

        Type[] types = ComputerParts.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                filterByType(computerpart, type));
        }
    }

    @ModelAttribute(name = "customPCOrder")
    public PCOrder order() {
        return new PCOrder();
    }
    @ModelAttribute(name = "customPC")
    public CustomPC customPC() {
        return new CustomPC();
    }
    @GetMapping //this is used for HTTP Get request (request data from resource)
    public String showDesignForm() {
        return "create";
    }
    @PostMapping //this is used for HTTP Post request (send data to a server for updating resource)
    //PostMapping works with RequestMapping on line 27
    public String processComp(@ModelAttribute("customPC") CustomPC customPC, @ModelAttribute("customPCOrder") PCOrder pcOrder) {
        pcOrder.addBuild(customPC); 
        log.info("Processing PC: {}", customPC);
        return "redirect:/orders/current";
    }
    
    private Iterable<ComputerParts> filterByType(List<ComputerParts> computerpart, Type type) {
        return computerpart.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
    }
}
