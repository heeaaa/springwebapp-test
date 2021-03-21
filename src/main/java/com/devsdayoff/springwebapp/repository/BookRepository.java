package com.devsdayoff.springwebapp.repository;

import com.devsdayoff.springwebapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
