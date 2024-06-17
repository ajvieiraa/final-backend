package com.example.demo.config;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        Author a1 = new Author(null, "J. K. Rowling");
        Author a2 = new Author(null, "Rick Riordan");

        Book b1 = new Book(null,"Harry Potter e a pedra filosofal",a1);
        Book b2 = new Book(null, "Harry Potter e a câmara secreta", a1);
        Book b3 = new Book(null, "Harry Potter e o cálice de fogo",a1);
        Book b4 = new Book(null,"Ladrão de raios", a2);
        Book b5 = new Book(null,"Mar de monstros", a2);

        authorRepository.saveAll(Arrays.asList(a1,a2));
        bookRepository.saveAll(Arrays.asList(b1,b2,b3,b4,b5));
    }
}
