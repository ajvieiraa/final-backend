package com.example.demo.config;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    Author a1 = new Author(null, "J. K. Rowling");
    Author a2 = new Author(null, "Rick Riordan");

    Book b1 = new Book(null,"Harry Potter e a pedra filosofal",a1);
    Book b2 = new Book(null, "Harry Potter e a câmara secreta", a1);
    Book b3 = new Book(null, "Harry Potter e o cálice de fogo",a1);
    Book b4 = new Book(null,"Ladrão de raios", a2);
    Book b5 = new Book(null,"Mar de monstros", a2);

}
