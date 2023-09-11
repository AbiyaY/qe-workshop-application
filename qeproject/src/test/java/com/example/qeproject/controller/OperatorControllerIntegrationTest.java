package com.example.qeproject.controller;

import com.example.qeproject.model.OperatorEnum;
import com.example.qeproject.service.NumberService;
import com.example.qeproject.service.OperatorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.UnsupportedEncodingException;

import static org.mockito.Mockito.when;

@WireMockTest(httpPort = 8080)
@SpringBootTest
@AutoConfigureMockMvc
public class OperatorControllerIntegrationTest
{
    @Autowired
    MockMvc mockMvc;

    @Autowired
    OperatorService operatorService;

    @Autowired
    OperatorController operatorController;

    String json;

    OperatorEnum operatorEnum = OperatorEnum.MULTIPLY;

    ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    void setUp() throws JsonProcessingException {
        String mathsApiUrl = "/mathservice/operator";

        json = mapper.writeValueAsString(operatorEnum);

        WireMock.stubFor(WireMock.post(mathsApiUrl)
                                 .withHeader("Content-Type", WireMock.equalTo("application/json"))
                                 .withRequestBody(WireMock.equalToJson(json))
                                 .willReturn(WireMock.aResponse()
                                                     .withStatus(201)
                                                     .withHeader("Content-Type", "application/json")
                                                     .withBody("100")));
    }

    @Test
    public void postOperatorAsAnObject_isCreated() throws Exception {

        RequestBuilder builder =
                MockMvcRequestBuilders.post("/operatorservice")
                                      .contentType(MediaType.APPLICATION_JSON)
                                      .content(json)
                                      .accept(MediaType.APPLICATION_JSON);

        MvcResult result =
                mockMvc.perform(builder)
                       .andExpect(MockMvcResultMatchers.status().isCreated())
                       .andDo(MockMvcResultHandlers.print())
                       .andReturn();

        String response = result.getResponse().getContentAsString();

        Assertions.assertEquals(100.0, Double.parseDouble(response));

    }

    void messyVersion() throws Exception {
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
