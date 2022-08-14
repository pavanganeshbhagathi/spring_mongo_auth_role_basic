package com.security.basicsecurity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.security.basicsecurity.entity.Roles;
import lombok.*;
import lombok.extern.java.Log;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Builder
@Getter
@ToString
public class profileDto {
    private String firstName;
    private String lastName;
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String email;
    private String profileImageUrl;
    private Date joinDate;
    private String role; //ROLE_USER{ read, edit }, ROLE_ADMIN {delete}
    private String[] authorities;
    private Optional<String> isActive;
    private Optional<String> isNotLocked;

}
