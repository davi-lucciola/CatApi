package com.felinos.cats.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@AutoConfigureMockMvc
public class CatControllerTest {

    @Autowired
    private MockMvc mock;

    @Test
    public void deveRetornarUmaListaDeGatos() throws Exception {
        this.mock.perform(get("/gatos")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].id").hasJsonPath())
                .andExpect(jsonPath("$.[0].especie").hasJsonPath())
                .andExpect(jsonPath("$.[0].corPelagem").hasJsonPath())
                .andExpect(jsonPath("$.[0].nome").hasJsonPath())
                .andExpect(jsonPath("$.[0].idade").hasJsonPath());

    }

    @Test
    public void deveRetornarUmGato() throws Exception {
        this.mock.perform(get("/gatos/2")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").hasJsonPath())
                .andExpect(jsonPath("$.especie").hasJsonPath())
                .andExpect(jsonPath("$.corPelagem").hasJsonPath())
                .andExpect(jsonPath("$.nome").hasJsonPath())
                .andExpect(jsonPath("$.idade").hasJsonPath());

    }
}
