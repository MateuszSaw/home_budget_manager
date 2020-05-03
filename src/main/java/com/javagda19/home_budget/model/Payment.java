package com.javagda19.home_budget.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private double income;

    @ManyToOne
//    @JoinColumn(name = "target_id")
    private Target target;

    @ManyToOne
    private AppUser appUser;

    @CreationTimestamp
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate paymentDate;

    public Payment(String name, double income, Target target) {
        this.name = name;
        this.income = income;
        this.target = target;
    }
}
