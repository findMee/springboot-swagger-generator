package com.example.springbootswaggercrud.crud.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.example.springbootswaggercrud.crud.model.Employee;

@RestController
@RequestMapping("v1/employee")
public class EmployeeController {

    private Map<String, Employee> empData = new HashMap<>();

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Employee> getEmployees() {
        return empData.values();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Employee addEmployee(@RequestBody Employee employee) {
        empData.put(employee.getId(), employee);
        return employee;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Employee updateEmployee(@RequestBody Employee employee) {
        empData.put(employee.getId(), employee);
        return employee;
    }

    @RequestMapping(path = "empId", method = RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable("empId") String empId) {
        empData.remove(empId);
    }

    @RequestMapping(path = "empId", method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable("empId") String empId) {
        return empData.get(empId);
    }

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World";
    }
}
