package com.security.basicsecurity.entity;

import com.security.basicsecurity.enums.RoleEnum;
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
    private RoleEnum roleName;
    private List<Permissions> permissions;
}
