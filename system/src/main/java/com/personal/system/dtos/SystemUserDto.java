package com.personal.system.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SystemUserDto {
    private Long id;
    private String name;
    private String lastName;
    private List<RolesDto> roles;
    private String documentData;
    private boolean active;
}
