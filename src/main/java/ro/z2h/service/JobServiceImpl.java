package ro.z2h.service;

import ro.z2h.dao.JobDao;
import ro.z2h.domain.Job;
import ro.z2h.utils.DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 11/13/2014.
 */
public class JobServiceImpl implements JobService {
    @Override
    public List<Job> findAllJobs() {
        List<Job> jobs = new ArrayList<Job>();
        Connection con = DatabaseManager.getConnection("ZTH_16", "passw0rd");

        JobDao objJobDao = new JobDao();
        try {
           jobs = objJobDao.getAllJobs(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return jobs;
    }
}
