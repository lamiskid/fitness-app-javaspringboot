package com.fitness.demo.Payload.Request;

import lombok.Data;

@Data
public class TokenRefreshRequest {
    private String refreshToken;
}
