package com.dans.multi.pro.test.service.job;

import com.dans.multi.pro.test.model.dto.job.JobResponse;

import java.util.List;

public interface JobService {
    JobResponse GetJob(String id) throws Exception;

    List<JobResponse> GetJobs() throws Exception;
}
