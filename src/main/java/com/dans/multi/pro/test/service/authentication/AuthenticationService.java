package com.dans.multi.pro.test.service.authentication;

import com.dans.multi.pro.test.model.dto.authentication.SignInPayload;
import com.dans.multi.pro.test.model.dto.authentication.SignInResponse;

public interface AuthenticationService {
    SignInResponse SignIn(SignInPayload payload) throws Exception;
}
