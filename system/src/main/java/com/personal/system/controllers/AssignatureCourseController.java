package com.personal.system.controllers;

import com.personal.system.dtos.AssignatureCourseDto;
import com.personal.system.services.AssignatureCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/assignature_course")
public class AssignatureCourseController {
    @Autowired
    private AssignatureCourseService assignatureCourseService;

    @PostMapping("/create")
    public AssignatureCourseDto createAssignatureCourse(@RequestBody AssignatureCourseDto request) {
        return assignatureCourseService.saveAssignatureCourse(request);
    }

    @PutMapping("/{id}")
    public AssignatureCourseDto updateAssignatureCourse(@PathVariable Long id, @RequestBody AssignatureCourseDto request) {
        return assignatureCourseService.updateAssignatureCourse(id, request);
    }

    @GetMapping("/{id}")
    public AssignatureCourseDto getAssignatureCourseById(@RequestParam Long id) {
        return assignatureCourseService.getAssignatureById(id);
    }

    @GetMapping("/assignature/{id}")
    public List<AssignatureCourseDto> getAssignatureCourseByAssignatureId(@PathVariable Long id) {
        return assignatureCourseService.getAssignatureCourseByAssignatureId(id);
    }
}
