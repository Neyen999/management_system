package com.personal.system.controllers;

import com.personal.system.dtos.AssignatureCourseDto;
import com.personal.system.dtos.AssignatureCourseUserDto;
import com.personal.system.services.AssignatureCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/assignature_course")
public class AssignatureCourseController {
    @Autowired
    private AssignatureCourseService assignatureCourseService;

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('SUPERADMIN')")
    public AssignatureCourseDto createAssignatureCourse(@RequestBody AssignatureCourseDto request) {
        return assignatureCourseService.saveAssignatureCourse(request);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('SUPERADMIN')")
    public AssignatureCourseDto updateAssignatureCourse(@PathVariable Long id, @RequestBody AssignatureCourseDto request) {
        return assignatureCourseService.updateAssignatureCourse(id, request);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('SUPERADMIN') or (hasAuthority('PROFESSOR') OR (hasAuthority('STUDENT')")
    public AssignatureCourseDto getAssignatureCourseById(@RequestParam Long id) {
        return assignatureCourseService.getAssignatureById(id);
    }

    @GetMapping("/assignature/{id}")
    @PreAuthorize("hasAuthority('SUPERADMIN')")
    public List<AssignatureCourseDto> getAssignatureCourseByAssignatureId(@PathVariable Long id) {
        return assignatureCourseService.getAssignatureCourseByAssignatureId(id);
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('SUPERADMIN')")
    public List<AssignatureCourseDto> getAllAssignatures() {
        return assignatureCourseService.getAllAssignatureCourses();
    }

    @GetMapping("/my_courses/{userId}")
    @PreAuthorize("hasAuthority('PROFESSOR') or hasAuthority('STUDENT')")
    public List<AssignatureCourseUserDto> getAssignaturesByUser(@PathVariable Long userId) {
        return assignatureCourseService.getAssignaturesCoursesByUserId(userId);
    }
}
