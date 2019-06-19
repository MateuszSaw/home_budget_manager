package com.javagda19.home_budget.repository;

import com.javagda19.home_budget.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    boolean existsByName(String name);

    UserRole findByName(String role);
}
