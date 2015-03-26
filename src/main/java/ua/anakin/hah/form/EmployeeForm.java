package ua.anakin.hah.form;


import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import ua.anakin.hah.entity.Division;
import ua.anakin.hah.entity.Employee;

public class EmployeeForm {
	
	@NotBlank(message="Имя не может состоять из пробелов")
	@Size(min=2, message = "Длина имени не может быть менее 2-х букв")
	private String firstName;
	
	@NotBlank(message="Фамилия не может состоять из пробелов")
	@Size(min=2, message = "Длина фамилии не может быть менее 2-х букв")
	private String lastName;
	
	@NotNull(message="Поле зарплаты не может быть пустым")
	@Digits(integer=5, fraction=2, message="Зарплата должна быть числом в формате NNNNN.nn")
	@DecimalMin(value="0", message="Зарплата должна быть больше 0")
	private Double salary;
	
	private String divisionName;
	
	@NotNull(message="Поле даты не может быть пустым")
	private String birthdate;
	
	private Boolean active;
	
	private Division division;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Division getDivision() {
		return division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}

	public void clear() {
		this.setFirstName("");
		this.setLastName("");
		this.setSalary(null);
		
	}

	public void setAll(Employee employee) {
		this.setFirstName(employee.getFirstName());
		this.setLastName(employee.getLastName());
		this.setSalary(employee.getSalary());
		this.setBirthdate(employee.getBirthdate().toString());
		this.setActive(employee.getActive());
		this.setDivisionName(employee.getDivision().toString());
	}
	
	
		
	
}
