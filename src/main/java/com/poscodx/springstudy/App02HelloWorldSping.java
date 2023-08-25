package com.poscodx.springstudy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSping {

	public static void main(String[] args) {
		
		//1. Lauch a Spring Context
		var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
		
		//2. Configure the things that we want Spring to manage - @Configuration
		//HelloWorldConfiguration - @Configuration
		//name - @Bean
		
		//3. Retrieving Beans managed by Spring
		System.out.println(context.getBean("name"));
		
		System.out.println(context.getBean("age"));
	
		System.out.println(context.getBean("person"));
		
		System.out.println(context.getBean("address2"));
		
		System.out.println(context.getBean(Address.class)); // class를 넣어줘도된다.!!
		
		System.out.println(context.getBean("person3Parameter"));
	}
}
