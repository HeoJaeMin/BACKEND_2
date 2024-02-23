package com.example.demo.user.domain.enitty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "user_info")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class UserInfo {

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "password")
    @JsonIgnore
    private String password;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "cell_phone", unique = true)
    private String cellPhone;
}
