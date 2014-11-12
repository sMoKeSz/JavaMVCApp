package ro.z2h.service;

import ro.z2h.dao.EmployeeDao;
import ro.z2h.domain.Employee;
import ro.z2h.utils.DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 11/12/2014.
 */
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeDao objEmpDao = new EmployeeDao();
    Connection con = DatabaseManager.getConnection("ZTH_16","passw0rd");
    @Override
    public List<Employee> findAllEmployees() {
      List<Employee> employeeList = new ArrayList<Employee>();

        try {
            employeeList = objEmpDao.getAllEmployees(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

      return employeeList;
    }

    @Override
    public Employee findOneEmployee(Long id) {
        Employee employee = new Employee();
        try {
            employee= objEmpDao.getEmployeeById(con,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }
}
