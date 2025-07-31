package com.api.book.BootRestBook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.BootRestBook.entities.Book;
import com.api.book.BootRestBook.services.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	//Get all books handler
	@GetMapping("/books")
	public List<Book> getBooks() {

		List<Book> books = bookService.getAllBooks();
		return books;
	}

	//Get book by id handler
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id") int id) {

		Book book = bookService.getBookById(id);
		return book;
	}

	//Create book handler
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {

		Book b = bookService.addBook(book);
		System.out.println(book);
		return b;
	}

	//Delete book by id handler
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bId) {
		System.out.println("Book has been deleted");
		this.bookService.deleteBook(bId);
	}

	//Update book by id handler
	@PutMapping("/books/{bookId}")
	public Book updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {

		this.bookService.updateBook(book, bookId);
		return book;
	}

}
