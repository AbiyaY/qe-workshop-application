package com.example.qeproject.controller;


import com.example.qeproject.model.Operator;
import com.example.qeproject.model.OperatorEnum;
import com.example.qeproject.service.OperatorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    OperatorEnum operatorEnum = OperatorEnum.MULTIPLY;
    String json = mapper.writeValueAsString(operatorEnum);


    //Stubbed service method which returns 2.00 when hit by the controller
    when(service.makePostRequestToMathService())
            .thenReturn(new ResponseEntity<Double>(2.0, HttpStatus.CREATED));

    MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/operatorservice")
                                                             .contentType(MediaType.APPLICATION_JSON)
                                                             .content(json)
                                                             .accept(MediaType.APPLICATION_JSON))
                              .andExpect(MockMvcResultMatchers.status().isCreated())
                              .andDo(MockMvcResultHandlers.print())
                              .andReturn();

   Assertions.assertEquals(2.0, Double.parseDouble(result.getResponse().getContentAsString()));

}

    @Test
    public void postStringAsInput_BadRequest() throws Exception {

        String wrongInput = """
                {"operator": "One"}""";

        mockMvc.perform(MockMvcRequestBuilders.post("/operatorservice")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(wrongInput)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andDo(MockMvcResultHandlers.print());
    }



}


