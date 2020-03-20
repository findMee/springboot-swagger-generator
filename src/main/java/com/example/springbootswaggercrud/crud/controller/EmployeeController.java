package com.example.springbootswaggercrud.crud.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.example.springbootswaggercrud.crud.model.Employee;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("employees/")
public class EmployeeController {

    private Map<String, Employee> empData = new HashMap<>();

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of Employees")
    public Collection<Employee> getEmployees() {
        return empData.values();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Adding the Employee", response = Employee.class)
    public Employee addEmployee(@RequestBody Employee employee) {
        empData.put(employee.getId(), employee);
        return employee;
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ApiOperation(value = "Updating the Employee", notes = "Provide the employee details to you want to update", response = Employee.class)
    public Employee updateEmployee(@RequestBody Employee employee) {
        empData.put(employee.getId(), employee);
        return employee;
    }

    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete the Employee")
    public String deleteEmployee(@PathVariable("id") String id) {
        empData.remove(id);
        return "Success";
    }

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Get a particular Employee", response = Employee.class)
    public Employee getEmployee(@PathVariable("id") String id) {
        return empData.get(id);
    }
}
