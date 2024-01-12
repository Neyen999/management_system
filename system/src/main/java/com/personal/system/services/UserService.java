package com.personal.system.services;

import com.personal.system.dtos.AuthRequestDto;
import com.personal.system.dtos.JwtResponseDto;
import com.personal.system.dtos.RegisterRequestDto;
import com.personal.system.dtos.SystemUserDto;
import com.personal.system.models.SystemUser;
import com.personal.system.repositories.SystemUserRepository;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private SystemUserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public JwtResponseDto loginUser(AuthRequestDto authRequestDto) {
        SystemUser user = userRepository.findByUsername(authRequestDto.getUsername());

        if (user == null) {
            throw new UsernameNotFoundException("Username: " + authRequestDto.getUsername() + " not found");
        }

        String username = authRequestDto.getUsername();
        String password = authRequestDto.getPassword();

        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        return new JwtResponseDto(jwtService.GenerateToken(username));
    }

    @Transactional
    public SystemUserDto registerUser(RegisterRequestDto registerRequestDto) {
        SystemUser existingUser = userRepository.findByUsername(registerRequestDto.getUsername());
        if (existingUser != null) {
            throw new RuntimeException("User exists");
        }

        SystemUser newUser = modelMapper.map(registerRequestDto, SystemUser.class);
        newUser.setPassword(passwordEncoder.encode(registerRequestDto.getPassword()));

        userRepository.save(newUser);

        return modelMapper.map(newUser, SystemUserDto.class);

    }

    @Transactional
    public SystemUserDto getLoggedUser(HttpServletRequest req) {
        String token = jwtService.getTokenFromHeader(req);
        String username = jwtService.extractUsername(token);

        SystemUser user = userRepository.findByUsername(username);

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        return modelMapper.map(user, SystemUserDto.class);
    }

    @Transactional
    public SystemUserDto updateUser(SystemUserDto request) {
        SystemUser user = userRepository.findById(request.getId()).orElseThrow(() -> new RuntimeException("User not found"));

        SystemUser updatedUser = modelMapper.map(request, SystemUser.class);

        userRepository.save(updatedUser);

        return modelMapper.map(updatedUser, SystemUserDto.class);
    }
}
