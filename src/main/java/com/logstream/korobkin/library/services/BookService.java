package com.logstream.korobkin.library.services;

import com.logstream.korobkin.library.models.Book;
import com.logstream.korobkin.library.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookService {



    private final BooksRepository booksRepository;

    @Autowired
    public BookService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Transactional(readOnly = true)
    public List<Book> findAll(){return booksRepository.findAll();}


    @Transactional(readOnly = true)
    public Book findOne(String isbn){
        Optional<Book> foundBook = booksRepository.findById(isbn);
        return foundBook.orElse(null);
    }


    public void save(Book book){
        booksRepository.save(book);
    }



    public void update(String isbn, Book updateBook){
        updateBook.setIsbn(isbn);
        booksRepository.save(updateBook);
    }



    public void delete(Book book){
        booksRepository.deleteById(book.getIsbn());
    }

}
