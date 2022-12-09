package com.dans.multi.pro.test.model.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse implements Serializable {

    @JsonProperty("errorMessage")
    private String errorMessage;
    @JsonProperty("code")
    private int code;

    public static BaseResponse SuccessBaseResponse() {
        return new BaseResponse("", 200);
    }
}


