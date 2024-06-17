package com.example.demo.service;

import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAll(){
        return authorRepository.findAll();
    }

    public Author findById(Long id){
        Optional<Author> obj = authorRepository.findById(id);
        return obj.get();
    }
    public Author insert(Author obj){
        return authorRepository.save(obj);
    }

    public void delete(Long id){
        authorRepository.deleteById(id);
    }

    public Author update(Long id, Author obj){
        Author entity = authorRepository.getReferenceById(id);
        updateData(entity, obj);
        return authorRepository.save(entity);
    }

    private void updateData(Author entity, Author obj) {
        entity.setName(obj.getName());
    }
}
