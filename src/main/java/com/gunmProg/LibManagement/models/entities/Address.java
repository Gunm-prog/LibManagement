package com.gunmProg.LibManagement.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Embeddable
@Table(name = "address")
@Data
@NoArgsConstructor
public class Address implements Serializable {

    @Serial
    private static final long serialVersionUID=1L;

    @Column(name = "number", nullable = false)
    private int number;

    @Column(name = "street", length = 50, nullable = false)
    private String street;

    @Column(name = "zip_code", length = 10, nullable = false)
    private String zipCode;

    @Column(name = "city", nullable = false)
    private String city;


}
