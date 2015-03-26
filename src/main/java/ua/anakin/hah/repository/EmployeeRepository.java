package ua.anakin.hah.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.anakin.hah.entity.Division;
import ua.anakin.hah.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	List<Employee> findByDivision(Division division);


}
