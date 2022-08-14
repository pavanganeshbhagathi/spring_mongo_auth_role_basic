package com.security.basicsecurity.entity;

import lombok.*;
import lombok.extern.java.Log;
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
    private Long id;
    private Optional<Boolean> read;
    private Optional<Boolean> write;
    private Optional<Boolean> update;
    private Optional<Boolean> delete;
}
