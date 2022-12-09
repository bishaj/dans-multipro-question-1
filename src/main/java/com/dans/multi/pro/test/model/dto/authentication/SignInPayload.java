package com.dans.multi.pro.test.model.dto.authentication;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInPayload {
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
}
