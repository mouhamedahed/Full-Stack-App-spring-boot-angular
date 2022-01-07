package tn.addixo.spring.service;

import org.springframework.http.ResponseEntity;

import tn.addixo.spring.entity.Employee;

public interface IEmployeeService {
	public ResponseEntity<?> addEmployee(Employee emp);
	public ResponseEntity<?> deleteEmployee(long id);
	public ResponseEntity<?> getAllEmployee();
	public ResponseEntity<?> updateEmployee(long id,Employee emp);
	public ResponseEntity<?> getOneByID(long id);

}
