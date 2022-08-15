package com.security.basicsecurity.dto;

import com.security.basicsecurity.enums.RoleEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@ToString
public class RolesDto {
    private RoleEnum roleName;
    private List<PermissionDto> permissions;
}
