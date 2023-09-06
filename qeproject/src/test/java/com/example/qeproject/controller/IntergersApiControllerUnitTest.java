package com.example.qeproject.controller;

import com.example.qeproject.service.IntegersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(IntergersApiController.class)
public class IntergersApiControllerUnitTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IntegersService service;


}
