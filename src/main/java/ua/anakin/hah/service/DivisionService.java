package ua.anakin.hah.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.anakin.hah.entity.Division;
import ua.anakin.hah.entity.Employee;
import ua.anakin.hah.repository.DivisionRepository;
import ua.anakin.hah.repository.EmployeeRepository;
import ua.anakin.hah.repository.RoleRepository;

@Service
@Transactional
public class DivisionService {
	
	
	@Autowired
	private DivisionRepository divisionRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Division> findAll() {
		return divisionRepository.findAll();
	}

	public Division findOne(long id) {
		return divisionRepository.findOne(id);
	}

	public void delete(long id) {
		divisionRepository.delete(id);
	}

	public void save(Division division) {
		division.setName(Tools.standardize(division.getName()));
		divisionRepository.save(division);
	}

	public List<Division> findAllWithEmployees() {
		List<Division> divisions = divisionRepository.findAll();
		for (Division division : divisions) {
			List<Employee> employees = employeeRepository.findByDivision(division);
			division.setEmployees(employees);
		}		
		return divisions;
	}

	public void updateDivision(Division editedDivision, long id) {
		divisionRepository.findOne(id).setName(Tools.standardize(editedDivision.getName()));
		divisionRepository.save(divisionRepository.findOne(id));
	}

}
