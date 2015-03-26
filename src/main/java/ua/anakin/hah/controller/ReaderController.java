package ua.anakin.hah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.anakin.hah.entity.Employee;
import ua.anakin.hah.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class ReaderController {

	@Autowired
	private EmployeeService employeeService;

	
	@RequestMapping("/{id}")
	public String employeeDetail(Model model, @PathVariable long id) {
		model.addAttribute("employee", employeeService.findOne(id));
		return "employee-detail";
	}
	
	
	@RequestMapping("/employees/{id}")
	public String employeeDetailPage(Model model, @PathVariable long id) {
		model.addAttribute("employee", employeeService.findOne(id));
		return "employee-detail";
	}

	
	
}
