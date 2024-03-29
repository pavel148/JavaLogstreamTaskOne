package com.logstream.korobkin.library.repositories;

import com.logstream.korobkin.library.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BooksRepository extends JpaRepository<Book, String> {
//        Optional<Book> findByIsbn(String isbn);
}
