package com.personal.system.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "assignatures")
public class Assignature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    // And assignature can have multiple courses, each one imparted by multiple professor, example Math-A, Math-B, Math-C
    // the main course is Math, but Math-A is teach by professor X, Math-B by professor Y and Math-C by professor Z.
    // Also this assignatures are related to users on that specified assignature
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "assignature_id")
    @JsonManagedReference
    private List<AssignatureCourse> assignatureCourses = new java.util.ArrayList<>();

}
