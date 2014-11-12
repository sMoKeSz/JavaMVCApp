package ro.z2h.service;

import ro.z2h.domain.Department;

import java.util.List;

/**
 * Created by user on 11/12/2014.
 */
public interface DepartmentService {

    List<Department> findAllDepartment();
}
