package com.security.basicsecurity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.security.basicsecurity.enums.BooleanEnum;
import com.security.basicsecurity.enums.IsActiveEnum;
import lombok.*;

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
    private List<RolesDto> role;  //ROLE_USER{ read, edit }, ROLE_ADMIN {delete}
    private Optional<IsActiveEnum> isActive;
    private Optional<BooleanEnum> isNotLocked;

}
