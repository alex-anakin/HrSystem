package ua.anakin.hah.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotBlank(message="Имя не может состоять из пробелов")
	@Size(min=2, message = "Длина имени не может быть менее 2-х букв")
	@Column(name = "first_name")
	private String firstName;
	
	@NotBlank(message="Фамилия не может состоять из пробелов")
	@Size(min=2, message = "Длина фамилии не может быть менее 2-х букв")
	@Column(name = "last_name")
	private String lastName;
	
	
	@Digits(integer=5, fraction=2, message="Зарплата должна быть числом в формате NNNNN.nn")
	@DecimalMin(value="0", message="Зарплата должна быть больше 0")
	private Double salary;
		
	@NotNull(message="Поле даты не может быть пустым")
	@Temporal(TemporalType.DATE)
	@Column
	private Date birthdate;
	
	private Boolean active;
	
	@ManyToOne
	@JoinColumn(name="division_id")	
	private Division division;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
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
	
	
}
