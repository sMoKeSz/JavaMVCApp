package ro.z2h.service;

import ro.z2h.domain.Job;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by user on 11/13/2014.
 */
public interface JobService {

    List<Job> findAllJobs() throws SQLException;
}
