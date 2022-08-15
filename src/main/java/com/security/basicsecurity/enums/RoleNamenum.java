package com.security.basicsecurity.enums;

import com.security.basicsecurity.constants.Authority;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleNamenum {
    ROLE_USER,
    ROLE_HR,
    ROLE_MANAGER,
    ROLE_ADMIN,
    ROLE_SUPER_ADMIN
}
