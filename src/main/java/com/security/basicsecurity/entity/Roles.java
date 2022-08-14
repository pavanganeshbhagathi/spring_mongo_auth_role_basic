package com.security.basicsecurity.entity;

import lombok.*;
import lombok.extern.java.Log;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document("roles")
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class Roles {
    @MongoId
    private Long id;
    private String roleName;
    private List<Permissions> permissions;
}
