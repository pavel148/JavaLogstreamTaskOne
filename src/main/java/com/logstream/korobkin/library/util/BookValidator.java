package com.logstream.korobkin.library.util;

import com.logstream.korobkin.library.controllers.BooksController;
import com.logstream.korobkin.library.models.Book;
import com.logstream.korobkin.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class BookValidator implements Validator {

    private final BookService bookService;

    @Autowired
    public BookValidator(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Book.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Book book = (Book) target;
        if(bookService.findOne(book.getIsbn()) != null){
            errors.rejectValue("isbn", "", "ISBN-код должен быть уникальным");
        }
    }
}
