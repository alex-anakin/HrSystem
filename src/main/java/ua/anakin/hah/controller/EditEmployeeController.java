package ua.anakin.hah.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.anakin.hah.form.EmployeeForm;
import ua.anakin.hah.service.DivisionService;
import ua.anakin.hah.service.EmployeeService;

@Controller
@SessionAttributes(types = EmployeeForm.class)
public class EditEmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DivisionService divisionService;
	
	@RequestMapping("/edit-employee/{id}")
	public String showEditEmployeePage(Model model, @PathVariable long id, EmployeeForm editEmployeeForm) {
		editEmployeeForm.setAll(employeeService.findOne(id));
		model.addAttribute("divisions", divisionService.findAll());
		model.addAttribute("editedEmployee", editEmployeeForm);
		return "edit-employee";
	}
		
	@RequestMapping(value="/edit-employee/{id}", method = RequestMethod.POST)
	public String executeEditEmployee(@Valid @ModelAttribute("editedEmployee") EmployeeForm editEmployeeForm, @PathVariable long id, BindingResult result) {
		if (result.hasErrors()) {
			return "edit-employee/{id}"; //TODO need fix: after validation error don't show list of divisions 
		}
		employeeService.updateEmployee(editEmployeeForm, id);
		//editEmployeeForm.clear();
		return "redirect:/edit-employee/{id}.html?success=true";
	}

}
