package com.dans.multi.pro.test.controller.job;

import com.dans.multi.pro.test.model.base.Precondition;
import com.dans.multi.pro.test.model.base.Response;
import com.dans.multi.pro.test.model.base.SingleBaseResponse;
import com.dans.multi.pro.test.model.dto.job.JobResponse;
import com.dans.multi.pro.test.service.job.JobService;
import com.dans.multi.pro.test.util.JwtTokenUtil;
import io.jsonwebtoken.lang.Strings;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class JobController {

    @Autowired
    private JobService jobService;

    @Autowired
    public JwtTokenUtil jwtTokenUtil;

    @GetMapping(value = "/v1/jobs")
    public SingleBaseResponse<Object> GetUserList(HttpServletRequest httpServletRequest) throws Exception {
        this.ValidateAccessToken(httpServletRequest, "PRIVATE");
        List<JobResponse> resp = jobService.GetJobs();
        return Response.SuccessSingleBaseResponse(resp);
    }

    @GetMapping(value = "/v1/jobs/{id}")
    public SingleBaseResponse<Object> GetUser(HttpServletRequest httpServletRequest, @PathVariable(value = "id") String id) throws Exception {
        this.ValidateAccessToken(httpServletRequest, "PRIVATE");
        JobResponse resp = jobService.GetJob(id);
        return Response.SuccessSingleBaseResponse(resp);
    }

    private Boolean ValidateAccessToken(HttpServletRequest httpServletRequest, String accessLevel) throws Exception {
        if ("PUBLIC".equals(accessLevel)) {
            return true;
        } else {
            String authorization = httpServletRequest.getHeader("Authorization");
            if (Objects.nonNull(authorization)) {
                String[] value = Strings.split(authorization, " ");
                if (value.length > 1 && "Bearer".equals(value[0])) {
                    String token = value[1];
                    String email = jwtTokenUtil.getEmailFromToken(token);
                    Precondition.Validate(jwtTokenUtil.validateToken(token, email), "Invalid Access");
                }
            }
            Precondition.Validate(false, "Invalid Access");
            return false;
        }
    }
}
