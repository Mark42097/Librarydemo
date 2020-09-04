package org.dxc.book.service;

import java.util.List;
import java.util.Optional;

import org.dxc.book.model.Book;
import org.dxc.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	BookRepository bookRepository;

	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public Optional<Book> getById(int id) {
		Optional<Book> result = bookRepository.findById(id);
		return result;
	}

	@Override
	public List<Book> getByPublisher(String publisher) {
		
		return bookRepository.findByPublisher(publisher);
	}

	@Override
	public void delete(int bookid) {
		bookRepository.deleteById(bookid);
		
	}

	@Override
	public HttpStatus saveBook(Book book) {
		boolean status = bookRepository.save(book) != null;
		return status ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
		
	}

	@Override
	public String updateBook(Book book) {
		boolean status = bookRepository.save(book) != null;
		
		return status ? "Updated Book Having ID: " +book.getBookid()+" Successfully" : "Failed";
	}

	@Override
	public List<Book> getByAuthorName(String authorname) {
		
		return bookRepository.findByAuthorName(authorname);
	}

	@Override
	public List<Book> getByCatagory(String catagory) {
		return bookRepository.findByCatagory(catagory);
	}
	

}
