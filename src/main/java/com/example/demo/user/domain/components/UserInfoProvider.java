package com.example.demo.user.domain.components;

import com.example.demo.exception.dto.CustomException;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.security.dto.JwtToken;
import com.example.demo.user.domain.dto.CustomUserDetail;
import com.example.demo.user.domain.repository.UserSearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class UserInfoProvider {
    private final UserSearchRepository userSearchRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;

    public UserDetails loadUserByUsername(String username) {
        return userSearchRepository.findByUserName(username).map(
                this::buildUserDetail).orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "해당 회원의 정보를 찾을 수 없습니다."));
    }

    public UserDetails buildUserDetail(CustomUserDetail userInfo) {
        return User.builder()
                .username(userInfo.getUsername())
                .password(passwordEncoder.encode(userInfo.getPassword()))
                .build();
    }

    @Transactional(readOnly = true)
    public JwtToken singIn(String userName, String password) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userName, password);

        Authentication auth = authenticationManagerBuilder.getObject().authenticate(authToken);

        return jwtTokenProvider.generateToken(auth);
    }
}
