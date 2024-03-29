package com.logstream.korobkin.library.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Book")
public class Book {
    @Id
    @Column(name = "isbn")
    @Size(min=17, max =22)
    private String isbn;


    @Column(name  = "title")
    @NotEmpty(message = "The title of the book should not be empty")
    @Size(min=1, max =100, message = "The title of the book should be from 1 to 100 characters long")
    private String title;
    public Book() {

    }

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public Book(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString(){
        return "isbn: " + this.isbn + ", title: " + this.title;
    }
}
