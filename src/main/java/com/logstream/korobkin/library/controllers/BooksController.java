package com.logstream.korobkin.library.controllers;

import com.logstream.korobkin.library.models.Book;
import com.logstream.korobkin.library.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping()
public class BooksController {

    private final BooksService bookService;

    @Autowired
    public BooksController(BooksService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    @Transactional(readOnly = true)
    public List<Book> showBooks(Model model) {
        return bookService.findAll();
    }

    @GetMapping("/isbn/{isbn}")
    @Transactional(readOnly = true)
    public Book searchBook(@PathVariable("isbn") String isbn, Model model) {
        return bookService.findOne(isbn);
    }

    @PostMapping("/{isbn}")
    public ResponseEntity<HttpStatus> newBook(@RequestBody @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(HttpStatus.BAD_REQUEST);
        }
        bookService.save(book);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/isbn/{isbn}")
    public List<Book> updateBook(@PathVariable("isbn") String isbn, @ModelAttribute("book") Book book) {
        bookService.update(isbn, book);
        return bookService.findAll();
    }

    @GetMapping("/delete/{isbn}")
    public List<Book> deleteBook(@PathVariable("isbn") String isbn) {
        Book book = bookService.findOne(isbn);
        if (book != null) {
            bookService.delete(book);
        }
        return bookService.findAll();
    }
}