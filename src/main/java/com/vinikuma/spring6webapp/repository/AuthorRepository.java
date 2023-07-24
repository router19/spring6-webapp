package com.vinikuma.spring6webapp.repository;

import com.vinikuma.spring6webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {

}
