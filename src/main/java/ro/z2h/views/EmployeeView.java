package ro.z2h.views;

import ro.z2h.domain.Department;
import ro.z2h.domain.Employee;
import ro.z2h.domain.Job;

import java.util.ArrayList;
import java.util.Date;

/**
 * EmployeeView.java
 */
public class EmployeeView {

    private Long id;
    private String firstName;
    private String lastName;
    private ArrayList<Employee> manager;
    private String email;
    private Date hireDate;
    private Double salary;
    private Double commissionPoints;
    private String phoneNumber;
    private ArrayList<Job> job;
    private ArrayList<Department> department;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getCommissionPoints() {
        return commissionPoints;
    }

    public void setCommissionPoints(Double commissionPoints) {
        this.commissionPoints = commissionPoints;
    }

    public ArrayList<Employee> getManager() {
        return manager;
    }

    public void setManager(ArrayList<Employee> manager) {
        this.manager = manager;
    }

    public ArrayList<Job> getJob() {
        return job;
    }

    public void setJob(ArrayList<Job> job) {
        this.job = job;
    }

    public ArrayList<Department> getDepartment() {
        return department;
    }

    public void setDepartment(ArrayList<Department> department) {
        this.department = department;
    }
}
