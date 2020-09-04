package org.dxc.book.service;

import java.util.List;
import java.util.Optional;

import org.dxc.book.model.Book;
import org.springframework.http.HttpStatus;

public interface BookService {

	public List<Book> findAll();

	public Optional<Book> getById(int id);

	public List<Book> getByPublisher(String publisher);

	public void delete(int bookid);

	public HttpStatus saveBook(Book book);

	public String updateBook(Book book);

	public List<Book> getByAuthorName(String authorname);

	public List<Book> getByCatagory(String catagory);
	
		
	
}
