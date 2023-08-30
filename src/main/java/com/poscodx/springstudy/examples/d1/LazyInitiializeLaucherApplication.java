package com.poscodx.springstudy.examples.d1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.poscodx.springstudy.examples.a1.DepInjectionLaucherApplication;

@Component
class ClassA{
	
}

@Component
@Lazy //늦은 초기화!
class ClassB{
	private ClassA classA;
	public ClassB(ClassA classA) {
		System.out.println("초기화 완료");
		this.classA = classA;
	}
}

@Configuration
@ComponentScan //자동으로 scan
public class LazyInitiializeLaucherApplication {

	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(LazyInitiializeLaucherApplication.class)){
			System.out.println("");
			context.getBean(ClassB.class); // ClassB를 호출할때 Bean으로 등록,,,!!
		};
	}

}
