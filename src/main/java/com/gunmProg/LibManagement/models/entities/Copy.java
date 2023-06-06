package com.gunmProg.LibManagement.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "copies")
@Data
@NoArgsConstructor
public class Copy implements Serializable {

    @Serial
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "copy_id")
    private Long id;

    @Column(name = "available", nullable = false)
    private boolean available;

    @ManyToOne
    @JsonIgnoreProperties("copies")
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne
    @JsonIgnoreProperties("copies")
    @JoinColumn(name = "library_id", nullable = false)
    private Library library;





}
