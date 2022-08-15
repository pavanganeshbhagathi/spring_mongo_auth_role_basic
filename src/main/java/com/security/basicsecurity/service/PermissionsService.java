package com.security.basicsecurity.service;

import com.security.basicsecurity.dto.PermissionDto;
import com.security.basicsecurity.entity.Permissions;
import com.security.basicsecurity.entity.Roles;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Optional;

@Configuration
@AllArgsConstructor
@Slf4j
public class PermissionsService {

    private MongoTemplate mongoTemplate;
    private final static String Permissions_COLLECTION = "permissions";

    public Permissions savePermissions(PermissionDto dto) {
        log.info(" dto {}" + dto);
        Permissions.PermissionsBuilder PermissionsBuilder = Permissions.builder();
        if (dto.getRead().isPresent())
            PermissionsBuilder.read(Boolean.parseBoolean(String.valueOf(dto.getRead().get())));
        if (dto.getWrite().isPresent())
            PermissionsBuilder.write(Boolean.parseBoolean(String.valueOf(dto.getWrite().get())));
        if (dto.getUpdate().isPresent())
            PermissionsBuilder.update(Boolean.parseBoolean(String.valueOf(dto.getUpdate().get())));
        if (dto.getDelete().isPresent())
            PermissionsBuilder.delete(Boolean.parseBoolean(String.valueOf(dto.getDelete().get())));


        Permissions byPermissions = this.findByPermissions(dto);
        log.info("byPermissions {}" + byPermissions);
        Optional<Permissions> byPermissionss = Optional.ofNullable(byPermissions);

        if (byPermissionss.isPresent())
            return byPermissions;


        Permissions build = PermissionsBuilder.build();
        log.info("{}" + build);
        Permissions save = mongoTemplate.save(build, Permissions_COLLECTION);
        return save;
    }

    public Permissions findByPermissions(PermissionDto dto) {
        log.info(" dto {}" + dto);
        Permissions.PermissionsBuilder PermissionsBuilder = Permissions.builder();
        if (dto.getRead().isPresent())
            PermissionsBuilder.read(Boolean.parseBoolean(String.valueOf(dto.getRead().get())));
        if (dto.getWrite().isPresent())
            PermissionsBuilder.write(Boolean.parseBoolean(String.valueOf(dto.getWrite().get())));
        if (dto.getUpdate().isPresent())
            PermissionsBuilder.update(Boolean.parseBoolean(String.valueOf(dto.getUpdate().get())));
        if (dto.getDelete().isPresent())
            PermissionsBuilder.delete(Boolean.parseBoolean(String.valueOf(dto.getDelete().get())));
        Permissions build = PermissionsBuilder.build();
        log.info("{}" + build);
        Query query = new Query();
        query.addCriteria(Criteria.where("read").is(build.getRead()));
        query.addCriteria(Criteria.where("write").is(build.getWrite()));
        query.addCriteria(Criteria.where("update").is(build.getUpdate()));
        query.addCriteria(Criteria.where("delete").is(build.getDelete()));


        Permissions save = mongoTemplate.findOne(query, Permissions.class);
        return save;
    }


}
