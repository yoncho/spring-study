package com.poscodx.springstudy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.poscodx.springstudy.game.GameRunner;
import com.poscodx.springstudy.game.GamingConsole;

public class App03GamingSpringBeans {

	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)){
			context.getBean(GamingConsole.class).up();
			
			context.getBean(GameRunner.class).run();
		};
	}

}
