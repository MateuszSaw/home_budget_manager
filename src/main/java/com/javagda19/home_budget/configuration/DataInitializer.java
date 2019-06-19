package com.javagda19.home_budget.configuration;

import com.javagda19.home_budget.model.AppUser;
import com.javagda19.home_budget.model.UserRole;
import com.javagda19.home_budget.repository.AppUserRepository;
import com.javagda19.home_budget.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        // wywoła się raz, po pełnej fazie inicjalizacji aplikacji

        createRoleIfNotExist("ADMIN");
        createRoleIfNotExist("USER");

        createUserWithRoleIfNotExist("admin", "admin", "ADMIN", "USER");
        createUserWithRoleIfNotExist("user", "user", "USER");
    }

    private void createUserWithRoleIfNotExist(String username, String password, String... roles) {
        if (!appUserRepository.existsByEmail(username)) {
            AppUser appUser = new AppUser();
            appUser.setEmail(username);
            appUser.setPassword(passwordEncoder.encode(password));

            appUser.setRoles(new HashSet<>(findRoles(roles)));

            appUserRepository.save(appUser);
        }
    }

    private List<UserRole> findRoles(String[] roles) {
        List<UserRole> userRoles = new ArrayList<>();

        for (String role : roles) {
            userRoles.add(userRoleRepository.findByName(role));
        }
        return userRoles;
    }

    private void createRoleIfNotExist(String roleName) {
        if (!userRoleRepository.existsByName(roleName)) {
            UserRole role = new UserRole();
            role.setName(roleName);

            userRoleRepository.save(role);
        }
    }


}
