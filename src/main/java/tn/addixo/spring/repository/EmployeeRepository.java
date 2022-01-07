package tn.addixo.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.addixo.spring.entity.Employee;

@Repository 
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
