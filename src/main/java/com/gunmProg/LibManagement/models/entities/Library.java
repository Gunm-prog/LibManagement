package com.gunmProg.LibManagement.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "library")
public class Library implements Serializable {

    @Serial
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "library_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "library")
    @JsonIgnoreProperties("libraries")
    private Set<Copy> copies;
}
