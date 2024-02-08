package com.personal.system.services;

//import com.asaplibs.errorHandling.exception.CustomException;

import com.personal.system.dtos.AssignatureCourseDto;
import com.personal.system.dtos.AssignatureCourseUserDto;
import com.personal.system.models.AssignatureCourse;
import com.personal.system.models.SystemUser;
import com.personal.system.repositories.AssignatureCourseRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssignatureCourseService {
    @Autowired
    private AssignatureCourseRepository assignatureCourseRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public AssignatureCourseDto saveAssignatureCourse(AssignatureCourseDto request) {
        AssignatureCourse assignatureCourse = modelMapper.map(request, AssignatureCourse.class);

        assignatureCourseRepository.save(assignatureCourse);

        return modelMapper.map(assignatureCourse, AssignatureCourseDto.class);
    }

    @Transactional
    public AssignatureCourseDto updateAssignatureCourse(Long id, AssignatureCourseDto request) {
//        AssignatureCourse assignatureCourse = assignatureCourseRepository.findById(id).orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Could not find Assignature", ""));
        AssignatureCourse assignatureCourse = assignatureCourseRepository.findById(id).orElseThrow(() -> new RuntimeException("Could not find Assignature"));

        assignatureCourse.setId(assignatureCourse.getId());
        assignatureCourse.setAssignature(assignatureCourse.getAssignature());
        assignatureCourse.setCourse(request.getCourse());

        Type systemUsers = new TypeToken<List<SystemUser>>() {}.getType();

        if (request.getProfessors() != null)
            assignatureCourse.setProfessors(modelMapper.map(request.getProfessors(), systemUsers));
        if (request.getStudents() != null)
            assignatureCourse.setStudents(modelMapper.map(request.getStudents(), systemUsers));

        return modelMapper.map(assignatureCourse, AssignatureCourseDto.class);
    }

    public List<AssignatureCourseDto> getAllAssignatureCourses() {
        List<AssignatureCourseDto> assignatureCourses = assignatureCourseRepository
                .findAll()
                .stream()
                .map(assignatureCourse -> modelMapper.map(assignatureCourse, AssignatureCourseDto.class))
                .collect(Collectors.toList());

        return assignatureCourses;
    }

    public AssignatureCourseDto getAssignatureById(Long id) {
//        AssignatureCourse assignatureCourse = assignatureCourseRepository.findById(id).orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Could not find assignature." , ""));
        AssignatureCourse assignatureCourse = assignatureCourseRepository.findById(id).orElseThrow(() -> new RuntimeException("Could not find assignature."));

        return modelMapper.map(assignatureCourse, AssignatureCourseDto.class);
    }

    public List<AssignatureCourseDto> getAssignatureCourseByAssignatureId(Long assignatureId) {
        List<AssignatureCourseDto> assignatureCourses = assignatureCourseRepository
                .findAssignatureCoursesByAssignatureId(assignatureId)
                .stream()
                .map(assignatureCourse -> modelMapper.map(assignatureCourse, AssignatureCourseDto.class))
                .collect(Collectors.toList());

        return assignatureCourses;
    }

    public List<AssignatureCourseUserDto> getAssignaturesCoursesByUserId(Long userId) {
        List<AssignatureCourse> assignatureCourses = assignatureCourseRepository.findAssignatureCoursesByUserId(userId);

        Type assignatureCoursesUserDto = new TypeToken<List<AssignatureCourseUserDto>>() {}.getType();

        return modelMapper.map(assignatureCourses, assignatureCoursesUserDto);
    }
}
