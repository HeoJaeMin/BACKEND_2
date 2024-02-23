package com.example.demo.user.domain.components;

import com.example.demo.user.domain.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserInfoProvider {
    private final UserInfoRepository userInfoRepository;

}
