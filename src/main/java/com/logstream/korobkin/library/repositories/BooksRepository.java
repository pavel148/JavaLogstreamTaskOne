package com.logstream.korobkin.library.repositories;

import com.logstream.korobkin.library.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BooksRepository extends JpaRepository<Book, String> {
//        Optional<Book> findByIsbn(String isbn);
}
