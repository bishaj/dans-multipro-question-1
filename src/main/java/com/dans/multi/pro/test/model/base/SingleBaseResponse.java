package com.dans.multi.pro.test.model.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public  class SingleBaseResponse<T> extends BaseResponse {
    @JsonProperty("value")
    private T value;
}

