package com.security.basicsecurity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.security.basicsecurity.enums.BooleanEnum;
import com.security.basicsecurity.enums.IsActiveEnum;
import com.security.basicsecurity.enums.RoleNamenum;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import java.util.Optional;

@Builder
@Getter
@ToString
public class profileUpdateDto {
    private Optional<String> firstName;
    private Optional<String> lastName;
    private Optional<String> username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Optional<String> password;
    private Optional<String> email;
    private Optional<String> profileImageUrl;
    private Optional<RoleNamenum> role;
    private Optional<IsActiveEnum> isActive;
    private Optional<BooleanEnum> isNotLocked;
}
