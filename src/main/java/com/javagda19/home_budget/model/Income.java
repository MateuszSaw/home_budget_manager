package com.javagda19.home_budget.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Min(value = 1)
    private double amount;

    @Enumerated(EnumType.STRING)
    private IncomeCategory category;

    @CreationTimestamp
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate incomeData;

    private String note;

    @ManyToOne
    private AppUser appUser;


    public Income(@Min(value = 1) double amount, IncomeCategory category, LocalDate incomeData, String note) {
        this.amount = amount;
        this.category = category;
        this.incomeData = incomeData;
        this.note = note;
    }
}
