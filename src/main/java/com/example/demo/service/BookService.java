package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book insert(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }
    public Book findById(Long id){
        Optional<Book> obj = bookRepository.findById(id);
        return obj.get();
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
    public Book update(Long id, Book obj){
        Book entity = bookRepository.getReferenceById(id);
        updateData(entity, obj);
        return bookRepository.save(entity);
    }
    private void updateData(Book entity, Book obj) {
        entity.setAuthor(obj.getAuthor());
        entity.setTitle(obj.getTitle());
    }
}
