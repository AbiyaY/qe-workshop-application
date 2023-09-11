package com.example.qeproject.controller;

import com.example.qeproject.model.NumberRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@WireMockTest(httpPort = 8080)
public class NumberControllerIntegrationTest {

    @Autowired
    ObjectMapper mapper;

    @Test
    public void postTwoNumbersAsAnObject_isCreated() {

        String mathsApiUrl = "/mathservice/integers";
        NumberRepo numberRepo = new NumberRepo(5, )

    }
}
