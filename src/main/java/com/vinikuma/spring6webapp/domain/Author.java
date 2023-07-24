package com.vinikuma.spring6webapp.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;


@Data
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;
}
