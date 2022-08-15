package com.security.basicsecurity.service;

import com.security.basicsecurity.dto.PermissionDto;
import com.security.basicsecurity.dto.RolesDto;

import com.security.basicsecurity.entity.Permissions;
import com.security.basicsecurity.entity.Roles;
import com.security.basicsecurity.enums.BooleanEnum;
import com.security.basicsecurity.enums.PermissionsOperations;
import com.security.basicsecurity.enums.RoleEnum;
import com.security.basicsecurity.enums.RoleNamenum;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class RolesService {
    private MongoTemplate mongoTemplate;
    private final static String PROFILE_COLLECTION = "roles";

    private PermissionsService permissionsService;

    public Roles saveRoles(RoleNamenum dto) {
        // log.info("getRoleName {}"+dto.getRoleName().name());
        //log.info("getRoleName values {}"+dto.getRoleName());

        Roles byRole = this.findByRole(dto);
        Optional<Roles> byRoleePresent = Optional.ofNullable(byRole);
        if (byRoleePresent.isPresent()) {
            return byRole;
        }

        Roles.RolesBuilder roleBuilder = Roles.builder();
        PermissionDto.PermissionDtoBuilder permissionDtoBuilder = PermissionDto.builder();
        RoleEnum roleEnum = RoleEnum.valueOf(dto.name());
        // log.info("getRoleName {}" + roleEnum.name());

        roleBuilder.roleName(RoleNamenum.valueOf(roleEnum.name()));
        List<String> permissionArray = Arrays.asList(roleEnum.getAuthorities());

        if (permissionArray.contains(PermissionsOperations.read.name())) {
            permissionDtoBuilder.read(Optional.ofNullable(BooleanEnum.TRUE));
        } else {
            permissionDtoBuilder.read(Optional.ofNullable(BooleanEnum.FALSE));
        }


        if (permissionArray.contains(PermissionsOperations.write.name())) {
            permissionDtoBuilder.write(Optional.ofNullable(BooleanEnum.TRUE));
        } else {
            permissionDtoBuilder.write(Optional.ofNullable(BooleanEnum.FALSE));
        }


        if (permissionArray.contains(PermissionsOperations.update.name())) {
            permissionDtoBuilder.update(Optional.ofNullable(BooleanEnum.TRUE));
        } else {
            permissionDtoBuilder.update(Optional.ofNullable(BooleanEnum.FALSE));
        }


        if (permissionArray.contains(PermissionsOperations.delete.name())) {
            permissionDtoBuilder.delete(Optional.ofNullable(BooleanEnum.TRUE));
        } else {
            permissionDtoBuilder.delete(Optional.ofNullable(BooleanEnum.FALSE));
        }


        Permissions permissions = permissionsService.savePermissions(permissionDtoBuilder.build());
        log.info(" permissions {}" + permissions);
        ObjectId permissionsId = new ObjectId(permissions.getId());
        roleBuilder.permissionsId(permissionsId);
        return mongoTemplate.save(roleBuilder.build(), PROFILE_COLLECTION);
    }

    public Roles findByRole(RoleNamenum dto) {
        Query query = new Query();
        query.addCriteria(Criteria.where("roleName").is(dto));
        return mongoTemplate.findOne(query, Roles.class);
    }

}
