package com.example.computers.compparts;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest//Web test for the home page controller

public class HomeControllerTest {
    
    @Autowired
    private MockMvc mockMvc; //Injection MockMvc
    
    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/")) //performs the HTTP Get Request
        .andExpect(status().isOk()) //Expects HTTP 200
        .andExpect(view().name("homepage")) //Expects the home page view
        .andExpect(content().string(containsString("Welcome to..."))); //Expects Welcome to...
    }
}
