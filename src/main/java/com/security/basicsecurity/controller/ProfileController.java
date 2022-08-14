package com.security.basicsecurity.controller;

import com.security.basicsecurity.dto.profileDto;
import com.security.basicsecurity.dto.profileUpdateDto;
import com.security.basicsecurity.entity.Profile;
import com.security.basicsecurity.service.ProfileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping(path = {"/user"})
@AllArgsConstructor
@Slf4j
public class ProfileController {

    private ProfileService profileService;

    @PostMapping("/add")
    public ResponseEntity<Profile> addNewUser(@Valid @RequestBody profileDto profilee) {
        return new ResponseEntity<Profile>(profileService.saveProfile(profilee), HttpStatus.CREATED);
    }

    @PatchMapping(path= "/updatebyid/{id}")
    public ResponseEntity<Long> updateUser(@PathVariable String id,@RequestBody Optional<profileUpdateDto> profilee) {
        log.info("inside controller {}" + profilee);
        log.info("inside id {}" + id);
        return new ResponseEntity<Long>(profileService.updateProfile(id, profilee.get()), HttpStatus.CREATED);
    }

    @DeleteMapping(path= "/deletebyid/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable String id)
    {
       return  new ResponseEntity<>(profileService.deleteById(id),HttpStatus.OK);
    }

}
