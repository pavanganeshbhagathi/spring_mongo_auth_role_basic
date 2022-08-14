package com.security.basicsecurity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    private Optional<String> role; //ROLE_USER{ read, edit }, ROLE_ADMIN {delete}
    private Optional<String[]> authorities;
    private Optional<String> isActive;
    private Optional<String> isNotLocked;
}
