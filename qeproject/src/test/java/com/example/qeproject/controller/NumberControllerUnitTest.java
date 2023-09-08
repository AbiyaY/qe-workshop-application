package com.example.qeproject.controller;

import com.example.qeproject.model.NumberRepo;
import com.example.qeproject.service.NumberService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(NumberController.class)
public class NumberControllerUnitTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    NumberService service;

    @Test
    public void postTwoNumbersAsAnObject_isCreated() throws Exception {

        NumberRepo integers = new NumberRepo(2, 5);
        String json = mapper.writeValueAsString(integers);

        mockMvc.perform(MockMvcRequestBuilders.post("/numberservice")
                                              .contentType(MediaType.APPLICATION_JSON)
                                              .content(json)
                                              .accept(MediaType.APPLICATION_JSON))
               .andExpect(MockMvcResultMatchers.status().isCreated())
               .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void postStringAsInput_BadRequest() throws Exception {

        String wrongInput = """
                {"number1": "One","number2":"Two"}""";

        mockMvc.perform(MockMvcRequestBuilders.post("/numberservice")
                                              .contentType(MediaType.APPLICATION_JSON)
                                              .content(wrongInput)
                                              .accept(MediaType.APPLICATION_JSON))
               .andExpect(MockMvcResultMatchers.status().isBadRequest())
               .andDo(MockMvcResultHandlers.print());
    }
}
