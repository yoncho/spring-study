package com.poscodx.springstudy.examples.a0;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.poscodx.springstudy.examples.a1.DepInjectionLaucherApplication;

@Configuration
@ComponentScan //자동으로 scan
public class SimpleSpringContextLaucherApplication {

	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(DepInjectionLaucherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		};
	}

}
