package com.ocean.app.lifecycle.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.demo.lifecycle.MyBean.customInit(..))")
    public void logBeforeInit() {
        System.out.println("🔍 AOP Proxy: Before MyBean.customInit()");
    }
}