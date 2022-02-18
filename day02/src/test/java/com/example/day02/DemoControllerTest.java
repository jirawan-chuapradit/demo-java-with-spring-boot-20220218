package com.example.day02;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoControllerTest {

    @Autowired
   private TestRestTemplate restTemplate;

    @MockBean
    private DemoService demoService;

    @Test
    void xxxx() {
        // call API
        DemoResponse result = restTemplate.getForObject("/demo/1", DemoResponse.class);
        //Verify result
        assertEquals(1,result.getCode());
        assertEquals("Result with id = 1" ,result.getMessage());

    }
}