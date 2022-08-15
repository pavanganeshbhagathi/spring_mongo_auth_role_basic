package com.security.basicsecurity.entity;

import com.security.basicsecurity.enums.RoleEnum;
import com.security.basicsecurity.enums.RoleNamenum;
import lombok.*;
import lombok.extern.java.Log;
import org.bson.types.ObjectId;
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
    private String id;
    private RoleNamenum roleName;
    private ObjectId permissionsId;
}
