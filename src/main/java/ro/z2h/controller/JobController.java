package ro.z2h.controller;

import ro.z2h.annotation.MyController;
import ro.z2h.annotation.MyRequestMethod;
import ro.z2h.domain.Job;
import ro.z2h.service.JobServiceImpl;

import java.util.List;

/**
 * Created by user on 11/13/2014.
 */
@MyController(urlPath = "/jobs")
public class JobController {

        JobServiceImpl objJob = new JobServiceImpl();

        @MyRequestMethod(urlPath = "/all")
        public List<Job> getAllEmployees() {

            return objJob.findAllJobs();
        }

}
