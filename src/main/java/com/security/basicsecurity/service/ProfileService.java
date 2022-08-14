package com.security.basicsecurity.service;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.security.basicsecurity.dto.profileDto;
import com.security.basicsecurity.dto.profileUpdateDto;
import com.security.basicsecurity.entity.Permissions;
import com.security.basicsecurity.entity.Profile;
import com.security.basicsecurity.entity.Roles;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.Date;

@Configuration
@AllArgsConstructor
@Slf4j
public class ProfileService {


    private MongoTemplate mongoTemplate;
    private final static String PROFILE_COLLECTION = "profile";
/*
    public Profile saveProfile(profileDto profilee) {
        log.info("{}" + profilee);

        Profile.ProfileBuilder builder = Profile.builder();
        Roles.RolesBuilder roleBuilder = Roles.builder();
        Permissions.PermissionsBuilder PermissionsBuilder = Permissions.builder();

        builder.firstName(profilee.getFirstName());
        builder.lastName(profilee.getLastName());
        builder.userName(profilee.getUsername());
        builder.email(profilee.getEmail());
        builder.role();
        builder.password(profilee.getPassword());
        builder.lastLoginDate(new Date());
        builder.lastLoginDateDisplay(new Date());
        builder.joinDate(new Date());

        if (profilee.getIsNotLocked().isPresent())
            builder.isActive(profilee.getIsActive().get().toLowerCase().trim().equals("true") ? Boolean.TRUE : Boolean.FALSE);
        else
            builder.isActive(Boolean.FALSE);

        if (profilee.getIsNotLocked().isPresent())
            builder.isNotLocked((profilee.getIsNotLocked().get().toLowerCase().trim().equals("true") ? Boolean.TRUE : Boolean.FALSE));
        else
            builder.isNotLocked(Boolean.FALSE);


        builder.profileImageUrl(profilee.getProfileImageUrl());


        Profile save = mongoTemplate.save(builder.build(), PROFILE_COLLECTION);

        return save;
    }
*/
    public long updateProfile(String id, profileUpdateDto profilee) {
        ObjectId profileId = new ObjectId(id);
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(profileId));

        Profile profileDB = mongoTemplate.findOne(query, Profile.class);
        log.info(" from db  data{}" + profileDB);

        Update profileUpdate = new Update();

        if (profilee.getFirstName().isPresent()) profileUpdate.set("firstName", profilee.getFirstName().get());
        if (profilee.getLastName().isPresent()) profileUpdate.set("lastName", profilee.getLastName().get());
        if (profilee.getUsername().isPresent()) profileUpdate.set("userName", profilee.getUsername().get());
        if (profilee.getPassword().isPresent()) profileUpdate.set("password", profilee.getPassword().get());
        if (profilee.getEmail().isPresent()) profileUpdate.set("email", profilee.getEmail().get());
        if (profilee.getProfileImageUrl().isPresent())
            profileUpdate.set("profileImageUrl", profilee.getProfileImageUrl().get());
        if (profilee.getRole().isPresent()) profileUpdate.set("role", profilee.getRole().get());
        if (profilee.getAuthorities().isPresent()) profileUpdate.set("authorities", profilee.getAuthorities().get());
        profileUpdate.set("lastLoginDate", new Date());
        profileUpdate.set("lastLoginDateDisplay", new Date());
        if (profilee.getIsActive().isPresent())
            profileUpdate.set("isActive", profilee.getIsActive().get().toLowerCase().trim().equals("true") ? Boolean.TRUE : Boolean.FALSE);

        if (profilee.getIsNotLocked().isPresent())
            profileUpdate.set("isNotLocked", profilee.getIsNotLocked().get().toLowerCase().trim().equals("true") ? Boolean.TRUE : Boolean.FALSE);

        UpdateResult updateResult = mongoTemplate.updateFirst(query, profileUpdate, Profile.class);
        log.info("updated db  data{}" + updateResult.toString());


        return updateResult.getModifiedCount();
    }

    public  Long deleteById(String id)
    {
        ObjectId profileId = new ObjectId(id);
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(profileId));
        DeleteResult remove = mongoTemplate.remove(query, Profile.class);
        return remove.getDeletedCount();
    }

}
