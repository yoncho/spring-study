package com.poscodx.springstudy.examples.h1;

import java.util.Arrays;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.poscodx.springstudy.game.GameRunner;

@ComponentScan //자동으로 scan
public class XmlConfigurationContextLaucherApplication {

	public static void main(String[] args) {
		
		try(var context = 
				new ClassPathXmlApplicationContext("contextConfiguration.xml")){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println(context.getBean("name"));
			System.out.println(context.getBean("age"));
			
			context.getBean(GameRunner.class).run();
		};
	}

}
