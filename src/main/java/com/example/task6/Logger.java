package com.example.task6;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {

    private int FirstApiUsages;
    private int SecondApiUsages;
    @Value("${my.max-api-usages}")
    private int MaxUsages;

    @Before("execution(public String com.example.task6.ApiController.firstApi())")
    public void BeforeFirstApi() throws Exception {
        if (FirstApiUsages < MaxUsages) {
            FirstApiUsages++;
        }
        else
            throw new Exception("Maximum API Requests");
    }

    @Before("execution(public String com.example.task6.ApiController.secondApi())")
    public void BeforeSecondApi() throws Exception {
        if (SecondApiUsages < MaxUsages) {
            SecondApiUsages++;
        }
        else
            throw new Exception("Maximum API Requests");
    }
}
