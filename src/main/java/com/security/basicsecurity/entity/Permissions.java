package com.security.basicsecurity.entity;

import com.security.basicsecurity.enums.BooleanEnum;
import lombok.*;
import lombok.extern.java.Log;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Optional;

@Document("permissions")
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class Permissions {
    @MongoId
    private String id;
    private Boolean read;
    private Boolean write;
    private Boolean update;
    private Boolean delete;
}
