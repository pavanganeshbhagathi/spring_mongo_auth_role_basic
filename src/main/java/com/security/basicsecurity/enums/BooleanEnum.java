package com.security.basicsecurity.enums;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
public enum BooleanEnum {
    TRUE(true),
    FALSE(false);
    final boolean status;

    BooleanEnum(boolean status) {
        this.status = status;
    }
}
