package com.personal.system.repositories;

import com.personal.system.models.AssignatureCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignatureCourseRepository extends JpaRepository<AssignatureCourse, Long> {
    @Query("SELECT ac FROM AssignatureCourse ac WHERE ac.assignature.id = :assignatureId")
    List<AssignatureCourse> findAssignatureCoursesByAssignatureId(@Param("assignatureId") Long assignatureId);
    @Query("SELECT ac FROM AssignatureCourse ac " +
            "WHERE :userId IN (SELECT p.id FROM ac.professors p) OR " +
            ":userId IN (SELECT s.id FROM ac.students s)")
    List<AssignatureCourse> findAssignatureCoursesByUserId(@Param("userId") Long userId);
}
