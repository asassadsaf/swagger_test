package com.fkp;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl1 implements TestService{
    @Override
    public void getName() {
        System.out.println("testService1");
    }
}
