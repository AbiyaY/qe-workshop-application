package com.example.qeproject.controller;


import com.example.qeproject.model.Operator;
import com.example.qeproject.service.OperatorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.util.Assert;

import static org.mockito.Mockito.when;

@WebMvcTest(OperatorApiController.class)
public class OperatorApiControllerUnitTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    OperatorService service;


    @Test
public void postOperatorAsAnObject_isCreated() throws Exception {
    Operator operator = new Operator("multiply");
    String json = mapper.writeValueAsString(operator);

    when(service.makePostRequestToMathService())
            .thenReturn(2.00);

    MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/operatorservice")
                                                             .contentType(MediaType.APPLICATION_JSON)
                                                             .content(json)
                                                             .accept(MediaType.APPLICATION_JSON))
                              .andExpect(MockMvcResultMatchers.status().isCreated())
                              .andDo(MockMvcResultHandlers.print())
                              .andReturn();

   Assertions.assertEquals(2.0, Double.parseDouble(result.getResponse().getContentAsString()));



}



}


