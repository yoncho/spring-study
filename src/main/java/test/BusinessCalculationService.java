package test;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

interface DataService{
	int[] retrieveData();
}

//@Component
@Repository
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

@Repository
@Qualifier("mysql")
class MySQLDataService implements DataService{
	
	@Override
	public int[] retrieveData() {
		return new int[] {1, 2, 3, 4, 5};
	}
}

@Service
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
