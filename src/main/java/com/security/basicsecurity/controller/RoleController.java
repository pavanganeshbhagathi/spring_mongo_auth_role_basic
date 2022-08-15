package com.security.basicsecurity.controller;

import com.security.basicsecurity.dto.RolesDto;
import com.security.basicsecurity.dto.profileDto;
import com.security.basicsecurity.entity.Permissions;
import com.security.basicsecurity.entity.Profile;
import com.security.basicsecurity.entity.Roles;
import com.security.basicsecurity.enums.RoleNamenum;
import com.security.basicsecurity.service.RolesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = {"/roles"})
@AllArgsConstructor
@Slf4j
public class RoleController {

    private RolesService rolesService;

    @PostMapping("/add")
    public ResponseEntity<Roles> addNewUser(@Valid @RequestBody RoleNamenum dto) {
       // log.info("getRoleName {}"+dto.getRoleName().name());
        log.info("getRoleName values {}"+dto);
        return new ResponseEntity<Roles>(rolesService.saveRoles(dto), HttpStatus.CREATED);
    }

}
