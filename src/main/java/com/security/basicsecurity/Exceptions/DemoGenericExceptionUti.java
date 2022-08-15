package com.security.basicsecurity.Exceptions;

import com.security.basicsecurity.enums.DemoGenericExceptionEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class DemoGenericExceptionUti {
    public void throwExceptionByEnum(DemoGenericExceptionEnum demoGenericExceptionEnum) {
        throw DemoGenericException.builder()
                .code(demoGenericExceptionEnum.getCode())
                .message(demoGenericExceptionEnum.getMessage())
                .detailMessage(demoGenericExceptionEnum.getDetailMessage())
                .build();
    }
}
