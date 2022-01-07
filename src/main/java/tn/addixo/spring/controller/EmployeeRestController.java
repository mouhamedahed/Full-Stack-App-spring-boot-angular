package tn.addixo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.addixo.spring.entity.Employee;
import tn.addixo.spring.service.IEmployeeService;
@CrossOrigin(origins = "http://localhost:4200")
@SuppressWarnings({"UnnecessaryLocalVariable", "SpringJavaAutowiredFieldsWarningInspection"})
@RestController
@RequestMapping("/addixo/employee")
public class EmployeeRestController {

	@Autowired
	private IEmployeeService empserv;
	
	
	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity<?> add(@RequestBody Employee emp)
	{
		return empserv.addEmployee(emp);
	}
	@PutMapping("/update/{id}")
	@ResponseBody
	public ResponseEntity<?> update(@PathVariable("id")long id,@RequestBody Employee emp)
	{
		return empserv.updateEmployee(id,emp);
	}
	@GetMapping("/getall")
	public ResponseEntity<?> getall()
	{
		return empserv.getAllEmployee();
	}
    @DeleteMapping("/delete/{id_emp}")
	public ResponseEntity<?> delete(@PathVariable("id_emp") long id)
	{
    	return empserv.deleteEmployee(id);
    }
	@GetMapping("/getOneByID/{id_emp}")
    public ResponseEntity<?> getOneByID(@PathVariable("id_emp") long id)
    {
		return empserv.getOneByID(id);
    }
	
}
