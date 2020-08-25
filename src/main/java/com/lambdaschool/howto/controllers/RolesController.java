package com.lambdaschool.howto.controllers;

import com.lambdaschool.howto.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RolesController
{
    @Autowired
    private UserService userService;

    @PutMapping(value = "/user/{userid}")
    public ResponseEntity<?> addAdminRole(@PathVariable long userid) {
        userService.addRoleAdmin(userid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
