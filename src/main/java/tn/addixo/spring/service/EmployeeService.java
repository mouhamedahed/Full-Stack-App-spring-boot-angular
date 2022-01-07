package tn.addixo.spring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.addixo.spring.RequestApiForm.MessageResponse;
import tn.addixo.spring.entity.Employee;
import tn.addixo.spring.repository.EmployeeRepository;

@Service
@Slf4j
public class EmployeeService implements IEmployeeService {

	@Autowired
	EmployeeRepository emprep;

	@Override
	public ResponseEntity<?> addEmployee(Employee emp) {

		List<Employee> employees = new ArrayList<>();

		emprep.findAll().forEach(employees::add);
		if (!employees.contains(emp)) {
			try {
				log.info("in addEmployee( )" + emp.toString());
				log.debug("Je viens de lancer la Save: " + emprep.save(emp));

			} catch (Exception e) {
				log.error("Erreur dans addEmployee() : " + e);

			}
			return ResponseEntity.ok(new MessageResponse("employee est bien enregistrer"));

		}

		else {

			return ResponseEntity.ok(new MessageResponse("employee existe "));

		}

	}

	@Override
	public ResponseEntity<?> deleteEmployee(long id) {
		Optional<Employee> optionalemp = emprep.findById(id);
        Map<String,Boolean> response =new HashMap<>();

		if (optionalemp.isPresent()) {
			try {
			
			Employee emp = optionalemp.get();
			
			log.info("in deleteEmployee( ) :" + emp.toString());
		             emprep.delete(emp);
		             response.put("employee est bien supprimer", Boolean.TRUE);

			}
		 catch (Exception e) {
			log.error("Erreur dans deleteEmployee() : " + e);

		}
			
			return ResponseEntity.ok(response);
	}

		else {

			return ResponseEntity.ok(new MessageResponse("employee n' existe pas"));

		}

	}

	@Override
	public ResponseEntity<?> getAllEmployee() {
		try
		{
		log.info("in getAllEmployee( ) liste des employee : " + emprep.findAll());
		log.debug("Je viens de lancer findAll(): " + emprep.findAll());

		}
		 catch (Exception e) {
				log.error("Erreur dans updateEmployee() : " + e);

			}
		return ResponseEntity.ok(emprep.findAll());

	}

	@Override
	public ResponseEntity<?> updateEmployee(long id,Employee emp) {
		Optional<Employee> optionalemp = emprep.findById(id);
		if (optionalemp.isPresent()) {
			try {
			Employee employeeToUpdate = optionalemp.get();
			log.info("in updateEmployee( ) avant modification:  " + employeeToUpdate.toString());

			employeeToUpdate.setFirstname(emp.getFirstname());
			employeeToUpdate.setLastename(emp.getLastename());
			employeeToUpdate.setEmail(emp.getEmail());
			log.info("in updateEmployee( ) apres modification:  " + employeeToUpdate.toString());

		
			log.debug("Je viens de lancer la Save: " + 	emprep.save(employeeToUpdate));
			}
			 catch (Exception e) {
					log.error("Erreur dans updateEmployee() : " + e);

				}
			return ResponseEntity.ok(new MessageResponse("employee est bien modifier"));

		} else {

			return ResponseEntity.ok(new MessageResponse("employee n' existe pas"));

		}
	}
	@Override
	public ResponseEntity<?> getOneByID(long id) {
		Optional<Employee> optionalemp = emprep.findById(id);
		Employee employee=new Employee();
		if (optionalemp.isPresent()) {
			try {
				 employee = optionalemp.get();
				log.info("in getOneByID( ) Employee:  " + employee.toString());
			}
		
		 catch (Exception e) {
				log.error("Erreur dans getOneByID() : " + e);

			}
			return ResponseEntity.ok(employee);


	         }
		else
		{
			return ResponseEntity.ok(new MessageResponse("employee n' existe pas"));
	
		}

		
	}

}
