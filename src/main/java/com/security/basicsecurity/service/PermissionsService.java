package com.security.basicsecurity.service;

import com.security.basicsecurity.dto.PermissionDto;
import com.security.basicsecurity.entity.Permissions;
import com.security.basicsecurity.entity.Roles;
import com.security.basicsecurity.enums.BooleanEnum;
import com.security.basicsecurity.enums.PermissionsOperations;
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
        //   log.info(" dto {}" + dto);

        Permissions.PermissionsBuilder PermissionsBuilder = Permissions.builder();

        if (dto.getRead().isPresent())
            PermissionsBuilder.read(convertStringToBoolean(dto.getRead()));

        if (dto.getWrite().isPresent())
            PermissionsBuilder.write(convertStringToBoolean(dto.getWrite()));

        if (dto.getUpdate().isPresent())
            PermissionsBuilder.update(convertStringToBoolean(dto.getUpdate()));

        if (dto.getDelete().isPresent())
            PermissionsBuilder.delete(convertStringToBoolean(dto.getDelete()));


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
        Query query = new Query();

        // log.info(" dto {}" + dto);
        if (dto.getRead().isPresent())
            query.addCriteria(Criteria.where(PermissionsOperations.read.name()).is(convertStringToBoolean(dto.getRead())));

        if (dto.getWrite().isPresent())
            query.addCriteria(Criteria.where(PermissionsOperations.write.name()).is(convertStringToBoolean(dto.getWrite())));

        if (dto.getUpdate().isPresent())
            query.addCriteria(Criteria.where(PermissionsOperations.update.name()).is(convertStringToBoolean(dto.getUpdate())));

        if (dto.getDelete().isPresent())
            query.addCriteria(Criteria.where(PermissionsOperations.delete.name()).is(convertStringToBoolean(dto.getDelete())));

        return mongoTemplate.findOne(query, Permissions.class);
    }

    private Boolean convertStringToBoolean(Optional<BooleanEnum> value) {
        return Boolean.parseBoolean(value.get().name());
    }


}
