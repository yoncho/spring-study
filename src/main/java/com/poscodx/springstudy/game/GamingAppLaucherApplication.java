package com.poscodx.springstudy.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.poscodx.springstudy.game")
public class GamingAppLaucherApplication {

	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(GamingAppLaucherApplication.class)){
			context.getBean(GamingConsole.class).up();
			
			context.getBean(GameRunner.class).run();
		};
	}

}
