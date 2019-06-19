package com.javagda19.home_budget.service;

import com.javagda19.home_budget.model.UserRole;
import com.javagda19.home_budget.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    /* @Value ładuje wartości z ustawień (application.properties) do zmiennych. */
    @Value("${user.default.roles}")
    private String[] defaultRoles;

    @Override
    public Set<UserRole> getDefaultUserRoles() {
        Set<UserRole> roles = new HashSet<>();

        for (String role : defaultRoles) {
            roles.add(userRoleRepository.findByName(role));
        }

        return roles;
    }
}
