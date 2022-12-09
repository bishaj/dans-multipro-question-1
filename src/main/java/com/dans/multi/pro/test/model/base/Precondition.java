package com.dans.multi.pro.test.model.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Precondition extends Error {
    private String message;

    public static Precondition Validate(boolean condition, String message) throws Exception{
        if (!condition) {
            throw Precondition.builder().message(message).build();
        }
        return null;
    }
}

