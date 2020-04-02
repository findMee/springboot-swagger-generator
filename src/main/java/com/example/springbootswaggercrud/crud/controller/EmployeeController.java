package com.example.springbootswaggercrud.crud.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.example.springbootswaggercrud.crud.model.Employee;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("employees")
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
        if (employee.getEmpId() != null) {
            empData.put(employee.getEmpId(), employee);
            return employee;
        }
        throw new RuntimeException("UserId can not be null");
    }

    @RequestMapping(path = "{empId}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updating the Employee", notes = "Provide the employee details to you want to update", response = Employee.class)
    public Employee updateEmployee(@PathVariable("empId") String empId, @RequestBody Employee employee) {
        if (employee.getEmpId() != null && empData.get(employee.getEmpId()) != null) {
            empData.put(employee.getEmpId(), employee);
            return employee;
        }
        throw new RuntimeException("Employee ");
    }

    @RequestMapping(path = "{empId}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete the Employee")
    public String deleteEmployee(@PathVariable("empId") String empId) {
        empData.remove(empId);
        return "Success";
    }

    @RequestMapping(path = "{empId}", method = RequestMethod.GET)
    @ApiOperation(value = "Get a particular Employee", response = Employee.class)
    public Employee getEmployee(@PathVariable("empId") String empId) {
        return empData.get(empId);
    }
}
