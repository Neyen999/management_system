package com.personal.system.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssignatureCourseDto {
    private Long id;
    private String course;
    private List<SystemUserDto> professors;
    private List<SystemUserDto> students;
}
