package ua.anakin.hah.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.anakin.hah.entity.Employee;
import ua.anakin.hah.form.EmployeeForm;
import ua.anakin.hah.repository.DivisionRepository;
import ua.anakin.hah.repository.EmployeeRepository;
import ua.anakin.hah.repository.RoleRepository;

@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DivisionRepository divisionRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	public Employee findOne(long id) {
		return employeeRepository.findOne(id);
	}

	public void delete(long id) {
		employeeRepository.delete(id);
	}

	public void save(EmployeeForm employeeForm) {
		Employee employee = new Employee();
		employeeRepository.save(setEmployeeAttributes(employee, employeeForm));
	}

	public void updateEmployee(EmployeeForm editEmployeeForm, long id) {
		employeeRepository.save(setEmployeeAttributes(employeeRepository.findOne(id), editEmployeeForm));		
	}
	
	private Employee setEmployeeAttributes(Employee employee, EmployeeForm employeeForm) {
		employee.setFirstName(Tools.standardize(employeeForm.getFirstName()));
		employee.setLastName(Tools.standardize(employeeForm.getLastName()));
		employee.setSalary(employeeForm.getSalary());
		try {
			employee.setBirthdate(new SimpleDateFormat("dd.mm.yyyy").parse(employeeForm.getBirthdate()));
		} catch (ParseException e) {
			employee.setBirthdate(new Date());
		}
		employee.setActive(employeeForm.getActive());
		employee.setDivision(divisionRepository.findByName(employeeForm.getDivisionName()));
		return employee;
	}
	

}
