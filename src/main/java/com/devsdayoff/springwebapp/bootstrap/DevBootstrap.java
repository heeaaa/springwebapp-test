package com.devsdayoff.springwebapp.bootstrap;

import com.devsdayoff.springwebapp.model.Author;
import com.devsdayoff.springwebapp.model.Book;
import com.devsdayoff.springwebapp.model.Publisher;
import com.devsdayoff.springwebapp.repository.AuthorRepository;
import com.devsdayoff.springwebapp.repository.BookRepository;
import com.devsdayoff.springwebapp.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        // Publishers
        Publisher harper = new Publisher("Harper Collins", "123 Abc Street");
        publisherRepository.save(harper);

        Publisher worx = new Publisher("Worx", "456 Xyz Street");
        publisherRepository.save(worx);

        // Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", harper);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        // Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "2345", worx);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }

}
