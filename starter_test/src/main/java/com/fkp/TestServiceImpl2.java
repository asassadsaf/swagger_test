package com.fkp;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl2 implements TestService{
    @Override
    public void getName() {
        System.out.println("testService2");
    }
}
