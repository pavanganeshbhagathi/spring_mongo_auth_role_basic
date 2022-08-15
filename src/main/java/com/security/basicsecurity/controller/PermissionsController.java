package com.security.basicsecurity.controller;

import com.security.basicsecurity.Exceptions.DemoGenericException;
import com.security.basicsecurity.dto.PermissionDto;
import com.security.basicsecurity.dto.profileDto;
import com.security.basicsecurity.entity.Permissions;
import com.security.basicsecurity.entity.Profile;
import com.security.basicsecurity.service.PermissionsService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = {"/permissions"})
@RequiredArgsConstructor
@Slf4j
public class PermissionsController {


    private PermissionsService permissionsService;
    @PostMapping("/add")
    public ResponseEntity<Permissions> addPermissions(@Valid @RequestBody PermissionDto dto) {
        log.info("addNewUser id {}" + dto);
        try {
            return  new ResponseEntity<Permissions>(permissionsService.savePermissions(dto), HttpStatus.CREATED);
        } catch (DemoGenericException demoGenericException) {
            return new ResponseEntity(demoGenericException, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
