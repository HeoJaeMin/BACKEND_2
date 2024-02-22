package com.example.demo.core.security;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtUtil {

    private final Key key;
    private final long accessTokenExpireTime;

    public JwtUtil(
            @Value("${jwt.expire_time}") long accessTokenExpireTime
    ){
        this.key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        this.accessTokenExpireTime =accessTokenExpireTime;
    }
}
