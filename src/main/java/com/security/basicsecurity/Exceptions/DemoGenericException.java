package com.security.basicsecurity.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class DemoGenericException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private int code;
    private String message;
    private String detailMessage;
}
