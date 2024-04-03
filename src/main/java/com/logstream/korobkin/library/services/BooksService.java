package com.logstream.korobkin.library.services;

import com.logstream.korobkin.library.models.Book;
import com.logstream.korobkin.library.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BooksService {

    private final BooksRepository booksRepository;

    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Transactional(readOnly = true)
    public List<Book> findAll() {
        return booksRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Book findOne(String isbn) {
        return booksRepository.findById(isbn).orElse(null);
    }

    public void save(Book book) {
        booksRepository.save(book);
    }

    public void update(String isbn, Book updateBook) {
        updateBook.setIsbn(isbn);
        booksRepository.save(updateBook);
    }

    public void delete(Book book) {
        booksRepository.deleteById(book.getIsbn());
    }
}