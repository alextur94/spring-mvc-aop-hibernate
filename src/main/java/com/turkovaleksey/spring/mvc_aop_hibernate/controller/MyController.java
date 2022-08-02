package com.turkovaleksey.spring.mvc_aop_hibernate.controller;

import com.turkovaleksey.spring.mvc_aop_hibernate.entity.Employee;
import com.turkovaleksey.spring.mvc_aop_hibernate.srevice.api.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private Service service;

    @RequestMapping("/")
    public String showAllEmps(Model model){
        List<Employee> allEmployees =  service.getAll();
        model.addAttribute("allEmps", allEmployees);
        return "all-employees";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        service.saveOrUpdate(employee);
        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") Integer id, Model model){
        Employee employee = (Employee) service.getByID(id);
        model.addAttribute("employee", employee);
        return "employee-info";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") Integer id) {
        service.deleteById(id);
        return "redirect:/";
    }
}
