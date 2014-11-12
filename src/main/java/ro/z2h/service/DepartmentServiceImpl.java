package ro.z2h.service;


import ro.z2h.dao.DepartmentDao;
import ro.z2h.domain.Department;
import ro.z2h.utils.DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 11/12/2014.
 */
public class DepartmentServiceImpl implements DepartmentService {
    DepartmentDao objDepDao = new DepartmentDao();
    Connection con = DatabaseManager.getConnection("ZTH_16", "passw0rd");

    @Override
    public List<Department> findAllDepartment() {
        List<Department> departmentList = new ArrayList<Department>();

        try {
            departmentList = objDepDao.getAllDepartments(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return departmentList;
    }
}
