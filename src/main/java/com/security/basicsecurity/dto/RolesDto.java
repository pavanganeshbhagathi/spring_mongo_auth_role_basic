package com.security.basicsecurity.dto;

import com.security.basicsecurity.enums.RoleEnum;
import com.security.basicsecurity.enums.RoleNamenum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.bson.types.ObjectId;

import java.util.List;

@Builder
@Getter
@ToString
@AllArgsConstructor
public class RolesDto {
    private RoleNamenum roleName;
}
