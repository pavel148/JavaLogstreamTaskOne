package com.logstream.korobkin.library;

import com.logstream.korobkin.library.controllers.BooksController;
import com.logstream.korobkin.library.models.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try{

			System.out.println("Код работает");

		}catch (Error e) {
			e.printStackTrace();
		}
	}
}
