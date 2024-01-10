package com.personal.system.repositories;

import com.personal.system.models.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemUserRepository extends JpaRepository<SystemUser, Long> {
    SystemUser findByUsername(String username);
}
