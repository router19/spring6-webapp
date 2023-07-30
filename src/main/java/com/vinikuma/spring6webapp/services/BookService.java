package com.vinikuma.spring6webapp.services;

import com.vinikuma.spring6webapp.domain.Book;
import org.springframework.stereotype.Service;

@Service
public interface BookService {
    Iterable<Book> findAll();
}
