package com.example.springworld.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldWelcomeTheUserOnHomePage() throws Exception {
        ResultActions actions = mockMvc.perform(get("/hello/billy")
                .contentType(MediaType.APPLICATION_JSON));
        MvcResult mvcResult = actions
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN)).andReturn();
        String responseString = mvcResult.getResponse().getContentAsString();
        assertEquals("Hello billy",responseString);

    }
}