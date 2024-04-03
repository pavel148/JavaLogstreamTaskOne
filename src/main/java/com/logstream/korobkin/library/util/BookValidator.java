package com.logstream.korobkin.library.util;

import com.logstream.korobkin.library.models.Book;
import com.logstream.korobkin.library.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class BookValidator implements Validator {

    private final BooksService bookService;

    @Autowired
    public BookValidator(BooksService bookService) {
        this.bookService = bookService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Book.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Book book = (Book) target;
        if (bookService.findOne(book.getIsbn()) != null) {
            errors.rejectValue("isbn", "", "ISBN-код должен быть уникальным");
        }
    }
}
