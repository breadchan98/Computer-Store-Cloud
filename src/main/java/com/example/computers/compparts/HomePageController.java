package com.example.computers.compparts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //controller
public class HomePageController {
    
    @GetMapping("/") //handles request for root path "/"

    public String home() {
        return "homepage";
        /*
        If the root path exists and received, the method will return "home"
         */
    }
}
