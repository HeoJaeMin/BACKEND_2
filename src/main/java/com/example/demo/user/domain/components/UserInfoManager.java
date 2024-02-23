package com.example.demo.user.domain.components;

import com.example.demo.security.JwtTokenProvider;
import com.example.demo.security.dto.JwtToken;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class UserInfoManager {

    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional(readOnly = true)
    public JwtToken singIn(String userName, String password) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userName, password);

        Authentication auth = authenticationManagerBuilder.getObject().authenticate(authToken);

        return jwtTokenProvider.generateToken(auth);
    }
}
