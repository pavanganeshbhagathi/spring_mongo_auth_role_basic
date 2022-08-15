package com.security.basicsecurity.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.security.basicsecurity.enums.BooleanEnum;
import com.security.basicsecurity.enums.IsActiveEnum;
import com.security.basicsecurity.enums.RoleNamenum;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;
import java.util.List;

@Document("profile")
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class Profile {
    @MongoId
    private String  id;
    //private String userId;
    private String firstName;
    private String lastName;
    private String userName;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String email;
    private String profileImageUrl;
    private Date lastLoginDate;
    private Date lastLoginDateDisplay;
    private Date joinDate;
    private RoleNamenum role; //ROLE_USER{ read, edit }, ROLE_ADMIN {delete}
    private IsActiveEnum isActive;
    private Boolean isNotLocked;

}
