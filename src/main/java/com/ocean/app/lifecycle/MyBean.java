package com.ocean.app.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyBean implements
        BeanNameAware, BeanFactoryAware, ApplicationContextAware,
        InitializingBean, DisposableBean {

    @Autowired
    private MyDependency dependency;

    public MyBean() {
        System.out.println("1️⃣ Constructor Called");
    }

    // ---- Aware Interfaces ----

    @Override
    public void setBeanName(String name) {
        System.out.println("2️⃣ BeanNameAware → Bean Name: " + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("3️⃣ BeanFactoryAware → BeanFactory set");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("4️⃣ ApplicationContextAware → ApplicationContext set");
    }

    // ---- Dependency Injected ----

    @PostConstruct
    public void postConstruct() {
        System.out.println("5️⃣ @PostConstruct Called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("6️⃣ InitializingBean.afterPropertiesSet() Called");
        dependency.sayHello();
    }

    public void customInit() {
        System.out.println("7️⃣ Custom Init-Method Called");
    }

    // ---- Shutdown ----

    @PreDestroy
    public void preDestroy() {
        System.out.println("8️⃣ @PreDestroy Called");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("9️⃣ DisposableBean.destroy() Called");
    }

    public void customDestroy() {
        System.out.println("🔟 Custom Destroy-Method Called");
    }
}