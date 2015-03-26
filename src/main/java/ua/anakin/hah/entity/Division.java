package ua.anakin.hah.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import ua.anakin.hah.annotation.UniqueName;

@Entity
public class Division {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Size(min = 2, message = "Название отдела не может быть меньше 2-х букв.")
	@NotBlank(message="Название отдела не может состоять из пробелов")
	@Column(unique = true)
	@UniqueName(message = "Такой отдел уже существует")
	private String name;
	
	@OneToMany(mappedBy="division", cascade=CascadeType.REMOVE)
	private List<Employee> employees;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
}
