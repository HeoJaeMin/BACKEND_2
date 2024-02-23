package com.example.demo.security.dto;

import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JwtToken {
    private String grantType;
    private String accessToken;
    private String refreshToken;
}
