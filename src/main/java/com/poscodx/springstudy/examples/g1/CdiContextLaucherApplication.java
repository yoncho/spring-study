package com.poscodx.springstudy.examples.g1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import jakarta.inject.Inject;
import jakarta.inject.Named;
//Spring Framework에서는 CDI가 구현되므로 CDI Annotation을 사용할 수 있다.
@Named //@Component 대체 CDI(Contexts and Dependency Injection) Annotation이 Spring Annotation을 대체함.
class BusinessService{
	DataService dataService;

	public DataService getDataService() {
		return dataService;
	}
	
	@Inject //@Autowired 대체 CDI	
	public void setDataService(DataService dataService) {
		System.out.println("Setter inject");
		this.dataService = dataService;
	}
}

@Named
class DataService{
	
}

@Configuration
@ComponentScan //자동으로 scan
public class CdiContextLaucherApplication {

	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(CdiContextLaucherApplication.class)){
			context.getBean(BusinessService.class).getDataService();
		};
	}

}
