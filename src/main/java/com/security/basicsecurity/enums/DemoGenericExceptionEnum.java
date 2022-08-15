package com.security.basicsecurity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DemoGenericExceptionEnum {
    PROFILE_ALREADY_EXISTS(1, "Profile Already Exists", "Profile Already Exists in our Database"),
    PROFILE_NOT_FOUND(2, "Profile Not found", "Profile Not Found in Our Database."),
    PROFILE_EMAIL_ALREADY_EXISTS(3, "Profile Email Already Exists", "Profile Email Already Exist");
    // DEPARTMENT_DOESNT_EXIST(3, "Department Doesn't Exists", "Department Doesn't Exists in Our Database."),
    // DEPARTMENT_ALREADY_EXIST(4, "Department Already Exists", "Department Already Exists in Our Database.");
    private final int code;
    private final String message;
    private final String detailMessage;
}
