package com.security.basicsecurity.dto;

import com.security.basicsecurity.enums.BooleanEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Optional;
@Builder
@Getter
@ToString
public class PermissionDto {
    private Optional<BooleanEnum> read;
    private Optional<BooleanEnum> write;
    private Optional<BooleanEnum> update;
    private Optional<BooleanEnum> delete;
}
