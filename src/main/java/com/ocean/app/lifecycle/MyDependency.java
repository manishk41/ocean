package com.ocean.app.lifecycle;

import org.springframework.stereotype.Component;

@Component
public class MyDependency {

    public void sayHello() {
        System.out.println("MyDependency: Hello!");
    }
}