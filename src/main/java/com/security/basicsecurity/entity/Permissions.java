package com.security.basicsecurity.entity;

import lombok.*;
import lombok.extern.java.Log;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document("permissions")
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class Permissions {
    @MongoId
    private Long id;
    private Boolean read;
    private Boolean write;
    private Boolean update;
    private Boolean delete;
}
