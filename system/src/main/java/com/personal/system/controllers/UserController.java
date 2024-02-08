package com.personal.system.controllers;

//import com.asaplibs.errorHandling.exception.CustomException;
import com.personal.system.dtos.SystemUserDto;
import com.personal.system.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/data")
    @PreAuthorize("hasAuthority('SUPERADMIN') or hasAuthority('ADMIN') or hasAuthority('USER')")
    public SystemUserDto getLoggedUser(HttpServletRequest req) {
        return userService.getLoggedUser(req);
    }

    @PutMapping("/{id}")
    public SystemUserDto updateUser(SystemUserDto req) {
        return userService.updateUser(req);
    }

}
