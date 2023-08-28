package test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
public class testMain {

	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(testMain.class)){
			System.out.println(context.getBean(BusinessCalculationService.class).findMax());
		};
		
	}

}
