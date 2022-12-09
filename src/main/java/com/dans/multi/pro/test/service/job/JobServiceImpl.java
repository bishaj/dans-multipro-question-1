package com.dans.multi.pro.test.service.job;

import com.dans.multi.pro.test.model.dto.job.JobResponse;
import com.dans.multi.pro.test.outbound.job.JobOutbound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobOutbound jobOutbound;

    @Override
    public JobResponse GetJob(String id) throws Exception {
        return jobOutbound.GetJobByID(id);
    }

    @Override
    public List<JobResponse> GetJobs() throws Exception {
        return jobOutbound.GetJobs();
    }
}
