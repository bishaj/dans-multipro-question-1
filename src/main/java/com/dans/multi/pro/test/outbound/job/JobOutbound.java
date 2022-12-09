package com.dans.multi.pro.test.outbound.job;

import com.dans.multi.pro.test.model.dto.job.JobResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface JobOutbound {
    JobResponse GetJobByID(String id) throws Exception;

    List<JobResponse> GetJobs() throws Exception;
}
