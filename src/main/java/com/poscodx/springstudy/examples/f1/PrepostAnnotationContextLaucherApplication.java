package com.poscodx.springstudy.examples.f1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.poscodx.springstudy.examples.a1.DepInjectionLaucherApplication;

@Component
class someClass{
	private SomeDependency someDependency;
	
	public someClass(SomeDependency someDependency) {
		this.someDependency = someDependency;
	}
}

@Component
class SomeDependency{
	
}
@Configuration
@ComponentScan //자동으로 scan
public class PrepostAnnotationContextLaucherApplication {

	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(PrepostAnnotationContextLaucherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		};
	}

}
