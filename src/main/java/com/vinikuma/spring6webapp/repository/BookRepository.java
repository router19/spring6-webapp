package com.vinikuma.spring6webapp.repository;

import com.vinikuma.spring6webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
