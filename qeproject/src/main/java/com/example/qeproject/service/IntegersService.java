package com.example.qeproject.service;

import com.example.qeproject.model.Integers;
import com.example.qeproject.util.Log;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;

@Service
public class IntegersService {
    private List<Integers> storedIntegers = new ArrayList<Integers>();

    public void storeIntegers(Integers integers){

        Logger logger = Log.getLogger();
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");

        Log.debug("IntegersService.storeIntegers invoked");
        storedIntegers.clear();
        storedIntegers.add(integers);
    }

    public void makePostRequestToMathService() {

        Log.debug("IntegersService.makePostRequestToMathService invoked");
        String resourceUrl = "http://localhost:8080/mathservice/integers";

        RestTemplate restTemplate = new RestTemplate();
        Void integerCreateResponse =
            restTemplate.postForObject(resourceUrl, storedIntegers.get(0), Void.class);
    }
}
