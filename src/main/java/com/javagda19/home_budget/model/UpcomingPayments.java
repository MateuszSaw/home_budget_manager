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
public class UpcomingPayments {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Min(value = 1)
    private double amount;

    @Enumerated(EnumType.STRING)
    private ExpenditureCategory category;

    @CreationTimestamp
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate paymentDeadline;

    private String note;

    @ManyToOne
    AppUser appUser;

    public UpcomingPayments(@Min(value = 1) double amount, ExpenditureCategory category, LocalDate paymentDeadline, String note) {
        this.amount = amount;
        this.category = category;
        this.paymentDeadline = paymentDeadline;
        this.note = note;
    }
}
