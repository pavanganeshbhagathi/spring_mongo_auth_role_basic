package com.security.basicsecurity.enums;


import com.security.basicsecurity.constants.Authority;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Getter
@NoArgsConstructor
@ToString
public enum RoleEnum {
    ROLE_USER(Authority.USER_AUTHORITIES),
    ROLE_HR(Authority.HR_AUTHORITIES),
    ROLE_MANAGER(Authority.MANAGER_AUTHORITIES),
    ROLE_ADMIN(Authority.ADMIN_AUTHORITIES),
    ROLE_SUPER_ADMIN(Authority.SUPER_ADMIN_AUTHORITIES);

    private  String[] authorities;

    RoleEnum(String... authorities) {
        this.authorities = authorities;
    }
}
