package com.mh.jpaboot01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class JpaBoot01Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(JpaBoot01Application.class, args);
	}

}
