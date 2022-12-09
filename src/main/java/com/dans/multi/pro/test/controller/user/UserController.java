package com.dans.multi.pro.test.controller.user;

import com.dans.multi.pro.test.model.dto.authentication.SignInPayload;
import com.dans.multi.pro.test.model.dto.authentication.SignInResponse;
import com.dans.multi.pro.test.model.base.Response;
import com.dans.multi.pro.test.model.base.SingleBaseResponse;
import com.dans.multi.pro.test.service.authentication.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping(value = "/v1/sign-in")
    public SingleBaseResponse<Object> SignIn(@RequestBody SignInPayload request) throws Exception {
        SignInResponse resp = authenticationService.SignIn(request);
        return Response.SuccessSingleBaseResponse(resp);
    }
}
