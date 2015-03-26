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

import ua.anakin.hah.entity.Division;
import ua.anakin.hah.service.DivisionService;
import ua.anakin.hah.service.EmployeeService;

@Controller
public class DivisionController {

	@Autowired
	private DivisionService divisionService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/divisions")
	public String showDivisionsPage(Model model) {
		model.addAttribute("divisions", divisionService.findAllWithEmployees());
		return "divisions";
	}
	
	@RequestMapping("/remove-division/{id}")
	public String removeDivision(@PathVariable long id) {
		divisionService.delete(id);
		return "redirect:/divisions.html";
	}
	
	@ModelAttribute("create-division")
	public Division createDivision() {
		return new Division();
	}
	
	@RequestMapping("/create-division")
	public String showCreateDivisionPage() {
		return "create-division";
	}
	
	@RequestMapping(value="/create-division", method = RequestMethod.POST)
	public String executeCreateDivision(@Valid @ModelAttribute("create-division") Division division, BindingResult result) {
		if (result.hasErrors()) {
			return "create-division";
		}
		divisionService.save(division);
		return "redirect:/create-division.html?success=true";
	}
	
	@RequestMapping("/edit-division/{id}")
	public String showEditDivisionPage(Model model, @PathVariable long id) {
		model.addAttribute("editedDivision", divisionService.findOne(id));
		return "edit-division";
	}	
	
	@RequestMapping(value="/edit-division/{id}", method = RequestMethod.POST)
	public String executeEditDivision(@Valid @ModelAttribute("edit-division") Division editedDivision, @PathVariable long id, BindingResult result) {
		if (result.hasErrors()) {
			return "edit-division/{id}";
		}
		divisionService.updateDivision(editedDivision, id);
		return "redirect:/edit-division/{id}.html?success=true";
	}
	
}
