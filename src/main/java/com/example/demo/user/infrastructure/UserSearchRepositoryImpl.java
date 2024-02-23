package com.example.demo.user.infrastructure;

import com.example.demo.user.domain.dto.CustomUserDetail;
import com.example.demo.user.domain.dto.QCustomUserDetail;
import com.example.demo.user.domain.enitty.QUserInfo;
import com.example.demo.user.domain.repository.UserSearchRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserSearchRepositoryImpl implements UserSearchRepository {

    private final JPAQueryFactory jpaQueryFactory;

    private final QUserInfo userInfo;

    @Override
    public Optional<CustomUserDetail> findByUserName(String userName) {
        return Optional.ofNullable(jpaQueryFactory.select(
                        new QCustomUserDetail(
                                userInfo.userName,
                                userInfo.password,
                                userInfo.email,
                                userInfo.cellPhone
                        )
                )
                .from(userInfo)
                .where(userInfo.userName.eq(userName)).fetchOne());
    }
}
