package com.dans.multi.pro.test.model.dto.authentication;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignInResponse {
    @JsonProperty("token")
    private String token;
}
