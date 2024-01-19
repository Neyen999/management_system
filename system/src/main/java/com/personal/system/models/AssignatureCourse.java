package com.personal.system.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "assignature_course")
public class AssignatureCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String course;
    @ManyToOne
    @JsonBackReference
    private Assignature assignature;
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "assignature_course_x_professors",
               joinColumns = @JoinColumn(name = "asignature_course_id"),
               inverseJoinColumns = @JoinColumn(name = "user_id"))
    @JsonManagedReference
    private List<SystemUser> professors = new ArrayList<>();
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "assignature_course_x_students",
            joinColumns = @JoinColumn(name = "asignature_course_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    @JsonManagedReference
    private List<SystemUser> students = new ArrayList<>();
}