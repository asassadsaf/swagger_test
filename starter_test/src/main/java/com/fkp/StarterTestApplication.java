package com.fkp;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class StarterTestApplication {

    @Autowired
    private List<TestService> testServices;

    @ApiOperation(value = "testMapping")
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public void testMapping(){
        System.out.println(testServices);
        for (TestService testService : testServices) {
            testService.getName();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(StarterTestApplication.class, args);
    }

}
