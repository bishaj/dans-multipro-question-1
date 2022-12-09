package com.dans.multi.pro.test.service.authentication;


import com.dans.multi.pro.test.entity.User;
import com.dans.multi.pro.test.model.dto.authentication.SignInPayload;
import com.dans.multi.pro.test.model.dto.authentication.SignInResponse;
import com.dans.multi.pro.test.model.base.Precondition;
import com.dans.multi.pro.test.repository.user.UserRepository;
import com.dans.multi.pro.test.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public SignInResponse SignIn(SignInPayload payload) throws Exception {
        User user = userRepository.findByEmail(payload.getEmail());
        Precondition.Validate(!Objects.isNull(user), "User Not Found");
        Precondition.Validate(user.getPassword().equals(payload.getPassword()), "Invalid Password");

        String token = jwtTokenUtil.generateToken(user);
        return SignInResponse.builder().token(token).build();
    }

}
