package com.devsdayoff.springwebapp.repository;

import com.devsdayoff.springwebapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
