package com.personal.system.controllers;

import com.personal.system.dtos.AssignatureDto;
import com.personal.system.services.AssignatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/assignature")
public class AssignatureController {
    @Autowired
    private AssignatureService assignatureService;

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('SUPERADMIN')")
    public AssignatureDto createAssignature(@RequestBody AssignatureDto request) {
        Exception ex = new Exception();
        return assignatureService.saveAssignature(request);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('SUPERADMIN')")
    public AssignatureDto getAssignature(@PathVariable Long id) {
        return assignatureService.getAssignature(id);
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('SUPERADMIN')")
    public List<AssignatureDto> getAllAssignatures() {
        return assignatureService.getAllAssignatures();
    }
}
