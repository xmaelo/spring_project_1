package com.api.web.web_api.controller;


import com.api.web.web_api.CustomProperty;
import com.api.web.web_api.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.api.web.web_api.service.EmployeeService;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @RequestMapping("/")
    public String home(Model model) {
        Iterable<Employee> listEmployee = service.getEmployees();
        model.addAttribute("employees", listEmployee);
        return "home";
    }
    @PostMapping("/saveEmployee")
    public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
        service.saveEmployee(employee);
        return new ModelAndView("redirect:/");
    }
    @GetMapping("/createEmployee")
    public String createEmployee(Model model) {
        Employee e = new Employee();
        model.addAttribute("employee", e);
        return "formNewEmployee";
    }

    @GetMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable("id") final int id, Model model) {
        Employee e = service.getEmployee(id);
        model.addAttribute("employee", e);
        return "formUpdateEmployee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public ModelAndView deleteEmployee(@PathVariable("id") final int id) {
        service.deleteEmployee(id);
        return new ModelAndView("redirect:/");
    }

}