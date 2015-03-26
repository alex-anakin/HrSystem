package ua.anakin.hah.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.anakin.hah.form.EmployeeForm;
import ua.anakin.hah.service.DivisionService;
import ua.anakin.hah.service.EmployeeService;

@Controller
@SessionAttributes(types = EmployeeForm.class)
public class CreateEmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DivisionService divisionService;
	
	@ModelAttribute("employee-form")
	public EmployeeForm createEmployeeForm() {
		return new EmployeeForm();
	}
	
	@RequestMapping("/create-employee")
	public String showCreateEmployeePage(Model model, EmployeeForm employeeForm) {
		model.addAttribute("divisions", divisionService.findAll());
		return "create-employee";
	}
		
	@RequestMapping(value="/create-employee", method = RequestMethod.POST)
	public String executeCreateEmployee(@Valid @ModelAttribute("employee-form") EmployeeForm employeeForm, BindingResult result) {
		if (result.hasErrors()) {
			return "create-employee"; //TODO need fix: after validation error don't show list of divisions 
		}
		employeeService.save(employeeForm);
		employeeForm.clear();
		return "redirect:/create-employee.html?success=true";
	}

}
