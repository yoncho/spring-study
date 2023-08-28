package com.poscodx.springstudy.examples.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//A <- B, C 주입

@Component
class BusinessClass{
	//Spring 은 Constructor 기반 주입을 추천한다. : 이유 -> 모든 초기화가 하나의 method에서 일어나기 때문..
	@Autowired
	Dependency1 dependency1;
	@Autowired
	Dependency2 dependency2;
	
//	@Autowired //생성자의 의존성은 제거해도 동작한다..!!
	public BusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
		super();
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}

//	@Autowired
//	public void setDependency1(Dependency1 dependency1) {
//		this.dependency1 = dependency1;
//	}
//	@Autowired
//	public void setDependency2(Dependency2 dependency2) {
//		this.dependency2 = dependency2;
//	}

	public String toString() {
		return "Using " + dependency1 + "and" + dependency2;
	}
}
@Component
class Dependency1{
	
}
@Component
class Dependency2{
	
}


@Configuration
@ComponentScan //자동으로 scan
public class DepInjectionLaucherApplication {

	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(DepInjectionLaucherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println(context.getBean(BusinessClass.class));
		};
	}

}
