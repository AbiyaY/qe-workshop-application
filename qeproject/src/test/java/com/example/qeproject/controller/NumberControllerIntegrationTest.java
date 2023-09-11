package com.example.qeproject.controller;

import com.example.qeproject.model.NumberRepo;
import com.example.qeproject.service.NumberService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WireMockTest(httpPort = 8080)
@SpringBootTest
@AutoConfigureMockMvc
public class NumberControllerIntegrationTest
{

    @Autowired
    MockMvc mockMvc;

    @Autowired
    NumberService numberService;

    @Autowired
    NumberController numberController;

    String json;
    NumberRepo numberRepo = new NumberRepo(5, 100);

    ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    void setUp() throws JsonProcessingException
    {
        String mathsApiUrl = "/mathservice/integers";

        json = mapper.writeValueAsString(numberRepo);

        WireMock.stubFor(WireMock.post(mathsApiUrl)
                                 .withHeader("Content-Type", WireMock.equalTo("application/json"))
                                 .withRequestBody(WireMock.equalToJson(json))
                                 .willReturn(WireMock.aResponse()
                                                     .withStatus(201)
                                                     .withHeader("Content-Type", "application/json")));

    }

    @Test
    public void postTwoNumbersAsAnObject_isCreated(WireMockRuntimeInfo wireMockRuntimeInfo) throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.post("/numberservice")
                                              .contentType(MediaType.APPLICATION_JSON)
                                              .content(json)
                                              .accept(MediaType.APPLICATION_JSON))
               .andExpect(MockMvcResultMatchers.status().isCreated())
               .andDo(MockMvcResultHandlers.print());
    }
}
