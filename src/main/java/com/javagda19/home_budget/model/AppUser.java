package com.javagda19.home_budget.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String password;

    @ManyToMany
    private Set<UserRole> roles;

    @OneToMany(mappedBy = "appUser")
    private List<Target> targetList;

    @OneToMany (mappedBy = "appUser")
    private List<Payment> paymentList;

    @Override
    public String toString() {
        return email;
    }
}
