package ua.anakin.hah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.anakin.hah.service.EmployeeService;

@Controller
public class IndexController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("employees", employeeService.findAll());
		return "index";
	}
	
	@RequestMapping("/info")
	public String info() {
		return "info";
	}

}
