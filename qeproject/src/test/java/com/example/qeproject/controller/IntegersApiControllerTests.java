package com.example.qeproject.controller;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.qeproject.QeprojectApplication;
import com.example.qeproject.model.Integers;
import com.example.qeproject.service.IntegersService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@WebMvcTest(IntergersApiController.class)
public class IntegersApiControllerTests
{
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void testThatNumbersGetStored()
    {
        Integers intValues = new Integers(2, 5);
        ResponseEntity<Void> responseEnt =
                restTemplate.postForEntity("/numberservice", intValues, Void.class);
        assertThat(responseEnt.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }
}

