package com.security.basicsecurity.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.security.basicsecurity.enums.BooleanEnum;
import com.security.basicsecurity.enums.IsActiveEnum;
import lombok.*;
import lombok.extern.java.Log;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.data.annotation.Id;
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
    private String userId;
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
    private List<Roles> role; //ROLE_USER{ read, edit }, ROLE_ADMIN {delete}
    private IsActiveEnum isActive;
    private BooleanEnum isNotLocked;

}
