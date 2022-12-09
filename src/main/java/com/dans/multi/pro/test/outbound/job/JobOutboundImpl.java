package com.dans.multi.pro.test.outbound.job;

import com.dans.multi.pro.test.model.dto.job.JobResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class JobOutboundImpl implements JobOutbound {
    @Override
    public JobResponse GetJobByID(String id) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://dev3.dansmultipro.co.id/api/recruitment/positions";
        ResponseEntity<JobResponse> response
                = restTemplate.getForEntity(resourceUrl + "/" + id, JobResponse.class);
        return response.getBody();
    }

    @Override
    public List<JobResponse> GetJobs() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://dev3.dansmultipro.co.id/api/recruitment/positions.json";
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        List<JobResponse> resp = objectMapper.readValue(response.getBody(), new TypeReference<>() {
        });
        return resp;
    }
}

