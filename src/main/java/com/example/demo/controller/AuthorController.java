package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorService.insert(author);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.findAll();
    }
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Author> findById(@PathVariable Long id){
        Author obj = authorService.findById(id);
        return ResponseEntity.ok().body(obj);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Author> update(@PathVariable Long id, @RequestBody Author obj){
        obj = authorService.update(id,obj);
        return ResponseEntity.ok().body(obj);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        authorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
