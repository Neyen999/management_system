package com.personal.system.controllers;

import com.personal.system.dtos.AuthRequestDto;
import com.personal.system.dtos.JwtResponseDto;
import com.personal.system.dtos.RegisterRequestDto;
import com.personal.system.dtos.SystemUserDto;
import com.personal.system.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class AuthenticationController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public SystemUserDto getLoggedUser(HttpServletRequest req) {
        return userService.getLoggedUser(req);
    }

    @PostMapping("/auth/login")
    public JwtResponseDto login(@RequestBody AuthRequestDto authRequestDto) {
        return userService.loginUser(authRequestDto);
    }

    @PostMapping("/auth/register/superadmin")
    public SystemUserDto registerSuperadmin(@RequestBody RegisterRequestDto request) {
        return userService.registerUser(request);
    }

    @PostMapping("/auth/register/user")
    public SystemUserDto registerUser(@RequestBody RegisterRequestDto request) {
        return userService.registerUser(request);
    }


}
