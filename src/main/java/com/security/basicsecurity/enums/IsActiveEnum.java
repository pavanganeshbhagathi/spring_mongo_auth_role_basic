package com.security.basicsecurity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
public enum IsActiveEnum {
    ACTIVE(true),
    INACTIVE(false),
    SUSPEND(false),
    BLOCKED(false),
    TERMINATED(false);
    final boolean isActive;

    IsActiveEnum(boolean isActive) {
        this.isActive = isActive;
    }
}
