package com.personal.system.controllers;

import com.personal.system.dtos.AssignatureDto;
import com.personal.system.services.AssignatureService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/assignature")
public class AssignatureController {
    @Autowired
    private AssignatureService assignatureService;

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('SUPERADMIN')")
    public AssignatureDto createAssignature(@RequestBody AssignatureDto request) {
        return assignatureService.saveAssignature(request);
    }
}
