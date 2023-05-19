package com.ust.bookfeign.controller;

import com.ust.bookfeign.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookRestController {

    @Autowired
    Environment environment;

    @GetMapping("/data")
    public String getBookData() {
        return "Data of BOOK-SERVICE, Running on port: " + environment.getProperty("local.server.port");
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Integer id) {
        return new Book(id, "Terraform for Beginners", 5000.00);
    }

    @GetMapping("/all")
    public List<Book> getAll() {
        return List.of(
                new Book(10, "Terraform for Beginners", 4000.00),
                new Book(11, "Docker for Absolute Beginners", 1200.00),
                new Book(12, "Certified Kubernetes Administrator Handbook", 2000.00),
                new Book(13, "Ansible Workbook", 3400.00)
        );
    }

    @GetMapping("/entity")
    public ResponseEntity<String> getEntityData() {
        return new ResponseEntity<String>("From BookRestController", HttpStatus.OK);
    }

}
