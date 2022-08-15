package com.security.basicsecurity.controller;

import com.security.basicsecurity.dto.profileDto;
import com.security.basicsecurity.entity.Profile;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = {"/role"})
@AllArgsConstructor
@Slf4j
public class RoleController {

    @PostMapping("/add")
    public ResponseEntity<Profile> addNewUser(@Valid @RequestBody profileDto profilee) {
        //return new ResponseEntity<Profile>(profileService.saveProfile(profilee), HttpStatus.CREATED);
        log.info("addNewUser id {}" + profilee);
        return null;
    }

}
