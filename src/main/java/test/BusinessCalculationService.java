package test;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.poscodx.springstudy.examples.a1.DepInjectionLaucherApplication;

interface DataService{
	int[] retrieveData();
}

@Component
@Primary
class MongoDbDataService implements DataService{
	
	//@Autowired
	public MongoDbDataService() {
		
	};
	@Override
	public int[] retrieveData() {
		return new int[] {11, 22, 33, 44, 55};
	}
	
}
@Component
class MySQLDataService implements DataService{
	
	//@Autowired
	public MySQLDataService() {
		
	}
	
	@Override
	public int[] retrieveData() {
		return new int[] {1, 2, 3, 4, 5};
	}
	
}

@Configuration
public class BusinessCalculationService {
	private DataService dataService;
	
	//@Autowired
	public BusinessCalculationService(DataService dataService) {
		this.dataService = dataService;
	}
	
	public int findMax() {
		return Arrays.stream(dataService.retrieveData()).max().orElse(0);
	}
}
