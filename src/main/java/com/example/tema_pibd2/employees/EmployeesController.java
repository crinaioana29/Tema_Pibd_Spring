package com.example.tema_pibd2.employees;

import com.example.tema_pibd2.employees.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
//used for making restful web services
//used at the class level and allows the class to handle the requests made by the client
@RestController
@RequestMapping(path = "api/v1/Employees")
public class EmployeesController {
    private final EmployeesService employeesService;

    @Autowired
//   to get rid of the injection of all self-dependencies
    public EmployeesController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @GetMapping
    public ModelAndView getEmployees() {
//        ModelAndView connects your java code (your instances) to the web page
        ModelAndView modelAndView=new ModelAndView("list-employees");

        List<Employees> list=employeesService.getEmployees();
        modelAndView.addObject("employees",list);
        return modelAndView;
    }
//   to be able to see those fields, you as a user must make a
//// GET request to the server on the respective page
    @GetMapping("/add/")
    public ModelAndView registerEmployeeForm(){
        ModelAndView mav=new ModelAndView("add-employee");
        Employees employees=new Employees();
        mav.addObject("employee",employees);
        return mav;
    }
    @PostMapping("/add/save/")
    public RedirectView registerNewEmployee(@ModelAttribute Employees employee) {
        employeesService.addNewEmployee(employee);
        RedirectView redirectView=new RedirectView();
        redirectView.setUrl("http://localhost:8181/api/v1/Employees/add/");
        //        redirect to add-employee
        return redirectView;
    }
    @DeleteMapping(path  = "{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") Long employeeId) {
        employeesService.deleteEmployee(employeeId);
    }
    @GetMapping(path="/update/{employeeId}")
    public ModelAndView updateEmployeeForm(){
        ModelAndView modelAndView=new ModelAndView("put-employee");
        Employees employees=new Employees();
        modelAndView.addObject("employee",employees);
        return modelAndView;
    }
    @PostMapping(path = "/update/{employeeId}")
    public RedirectView updateEmployee(
            @PathVariable("employeeId") Long employeeId,
            @ModelAttribute Employees employees) {
        employeesService.updateEmployee(employeeId, employees.getSurname(), employees.getFirst_name());
        RedirectView redirectView=new RedirectView();
        redirectView.setUrl("http://localhost:8181/api/v1/Employees");
        return redirectView;
    }

}
