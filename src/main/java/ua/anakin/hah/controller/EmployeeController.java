package ua.anakin.hah.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.anakin.hah.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/employee-detail/{id}")
	public String employeeDetailPage(Model model, @PathVariable long id) {
		model.addAttribute("employee", employeeService.findOne(id));
		return "employee-detail";
	}
	
	@RequestMapping("/remove-employee/{id}")
	public String removeEmployee(@PathVariable long id) {
		employeeService.delete(id);
		return "redirect:/index.html";
	}
	
}
