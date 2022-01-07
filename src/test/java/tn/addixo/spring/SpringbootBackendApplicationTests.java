package tn.addixo.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.addixo.spring.entity.Employee;
import tn.addixo.spring.service.IEmployeeService;

@SpringBootTest
class SpringbootBackendApplicationTests {

	@Autowired 
	IEmployeeService serv;
	
	@Test
	void employeeLoads() throws Exception{
		
		Employee emp =new Employee(1,"mouhamed", "ahed", "ahedmouhamed@gmail.com");
		
		serv.addEmployee(emp);
		serv.getAllEmployee();
		Employee emp2 =new Employee(1,"med", "med", "medmed@gmail.com");

		serv.updateEmployee(emp2.getId(),emp);
		serv.deleteEmployee(emp.getId());

		
	}

}
