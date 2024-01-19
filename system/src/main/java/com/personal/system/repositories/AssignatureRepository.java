package com.personal.system.repositories;

import com.personal.system.models.Assignature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignatureRepository extends JpaRepository<Assignature, Long> {
}
