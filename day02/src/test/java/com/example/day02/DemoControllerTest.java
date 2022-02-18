package com.example.day02;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoControllerTest {

    @Autowired
   private TestRestTemplate restTemplate;

    @MockBean
    private DemoService demoService;

    @Test
    void case_iput_1_should_return_result_with_id_equal_1() {
        // call API
        // create stub
        when(demoService.process(1)).thenReturn("Result with id = 1");
        DemoResponse result = restTemplate.getForObject("/demo/1", DemoResponse.class);
        //Verify result
        assertEquals(1,result.getCode());
        assertEquals("Result with id = 1" ,result.getMessage());
    }

    @Test
    void case_iput_500_should_return_err() {
        // call API
        // create stub
        when(demoService.process(500)).thenReturn("error cannot process");
        DemoResponse result = restTemplate.getForObject("/demo/500", DemoResponse.class);
        //Verify result
        assertEquals(500,result.getCode());
        assertEquals("error cannot process" ,result.getMessage());
    }
}