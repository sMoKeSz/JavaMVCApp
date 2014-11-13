package ro.z2h.controller;

import ro.z2h.annotation.MyController;
import ro.z2h.annotation.MyRequestMethod;
import ro.z2h.domain.Employee;
import ro.z2h.service.EmployeeServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 11/11/2014.
 */

@MyController(urlPath = "/employee")

public class EmployeeController {
    EmployeeServiceImpl objEmployee = new EmployeeServiceImpl();

    @MyRequestMethod(urlPath = "/all")
    public List<Employee> getAllEmployees() {

        return objEmployee.findAllEmployees();
    }

    @MyRequestMethod(urlPath = "/one")
    public Employee getOneEmployee(String id) {

        return objEmployee.findOneEmployee(Long.valueOf(id));
    }
    @MyRequestMethod(urlPath = "/delete")
    public void deleteOneEmployee(String id){
       objEmployee.deleteOneEmployee(Long.valueOf(id));
    }
}