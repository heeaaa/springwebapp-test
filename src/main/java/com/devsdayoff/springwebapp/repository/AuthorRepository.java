package com.devsdayoff.springwebapp.repository;

import com.devsdayoff.springwebapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
