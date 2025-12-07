package com.ocean;

import com.ocean.app.lifecycle.MyBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OceanApplication {

	public static void main(String[] args) {
		SpringApplication.run(OceanApplication.class, args);
	}

	@Bean(initMethod = "customInit", destroyMethod = "customDestroy")
	public MyBean myBean() {
		return new MyBean();
	}

}
