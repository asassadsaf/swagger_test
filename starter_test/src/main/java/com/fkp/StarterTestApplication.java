package com.fkp;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
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
        ConfigurableApplicationContext run = SpringApplication.run(StarterTestApplication.class, args);
        TestConfiguration testConfiguration = (TestConfiguration) run.getBean("testConfiguration");
        TestConfiguration.User user = (TestConfiguration.User) run.getBean("user");
        TestConfiguration.User user2 = (TestConfiguration.User) run.getBean("user2");
        System.out.println(testConfiguration);
        System.out.println(testConfiguration.getUser());
        System.out.println(testConfiguration.getUser());
        System.out.println(user);
        System.out.println(user2);
    }

}
