package com.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.dao.EmployeeDao;
import com.mvc.model.Employee;

@Controller
public class HomeController {

	@Autowired
	EmployeeDao dao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "/home";
	}

	@RequestMapping(value = "/empform", method = RequestMethod.GET)
	public String showForm(Model model) {
		model.addAttribute("emp", new Employee());
		return "/empform";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("emp") Employee emp) {
		dao.save(emp);
		return "redirect:/viewemp";
	}

	@RequestMapping(value = "/viewemp", method = RequestMethod.GET)
	public String viewemp(Model m) {
		List<Employee> list = dao.getEmployees();
		m.addAttribute("list", list);
		return "/viewemp";
	}

	@RequestMapping(value = "/editemp/{id}")
	public String edit(@PathVariable int id, Model m) {
		Employee emp = dao.getEmpById(id);
		m.addAttribute("command", emp);
		return "/empeditform";
	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("emp") Employee emp) {
		dao.update(emp);
		return "redirect:/viewemp";
	}

	@RequestMapping(value = "/deleteemp/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		dao.delete(id);
		return "redirect:/viewemp";
	}
}
