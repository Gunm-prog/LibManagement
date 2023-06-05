package com.gunmProg.LibManagement.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "loans")
@Data
@NoArgsConstructor
public class Loan implements Serializable {

    @Serial
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "loan_id")
    private Long id;

    @Column(name = "start_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @Column(name = "end_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    /*@ManyToOne
    @JsonIgnoreProperties("loans")
    @JoinColumn(name = "copy_id", nullable = false)
    private Copy copy;

    @ManyToOne
    @JsonIgnoreProperties("loans")
    @JoinColumn(name = "user_id", nullable = false)
    private User user;*/






}
