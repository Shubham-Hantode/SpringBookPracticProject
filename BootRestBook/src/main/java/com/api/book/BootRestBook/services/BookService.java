package com.api.book.BootRestBook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.book.BootRestBook.entities.Book;

@Component
public class BookService {

	private static List<Book> list = new ArrayList<>();

	static {

//		List<Book> list=null;
		list.add(new Book(1, "JAVA", "Shubham"));
		list.add(new Book(2, "Python", "Shubham"));
		list.add(new Book(3, "Sql", "Shubham"));

	}

	// Get all books
	public List<Book> getAllBooks() {

		return list;
	}

	// Get book by Id
	public Book getBookById(int id) {
		Book book = null;
		book = list.stream().filter(e -> e.getId() == id).findFirst().get();

		return book;
	}

	// Adding book
	public Book addBook(Book b) {
		list.add(b);
		return b;
	}

	// Delete book
	public void deleteBook(int id) {

		list = list.stream().filter(book -> book.getId() != id).collect(Collectors.toList());
	}

	// Update book
	public void updateBook(Book book, int bookId) {

		list = list.stream().map(b -> {
			if (b.getId() == bookId) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());
	}

}
