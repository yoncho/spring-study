package com.poscodx.springstudy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// record : java bean을 위함
//  record type은 getter/setter/constructor 를 생성할 필요가 없다. 모두 자동 생성됨.
record Person (String name, int age, Address address) {}; 

record Address (String firstLine, String city) {};

@Configuration
public class HelloWorldConfiguration {
	
	@Bean
	public String name() {
		return "Yoncho";
	}
	
	@Bean
	public int age() {
		return 15;
	}
	
	@Bean
	public Person person() {
		return new Person("yoncho", 17, new Address("MAIN", "SEOUL"));
	}
	
	@Bean
	public Person person2MethodCall() {
		return new Person(name(), age() ,new Address("MAIN", "SEOUL")); // name, age bean 호출
	}
	
	@Bean
	public Person person3Parameter(String name, int age, Address address2) { //name, age, address2
		return new Person(name, age ,address2); // name, age bean 호출
	}
	
	@Bean(name = "address2") //Bean의 이름을 지정...!! 기본은 함수명
	public Address address() {
		return new Address("seongdong-gu", "seoul");
	}
}
