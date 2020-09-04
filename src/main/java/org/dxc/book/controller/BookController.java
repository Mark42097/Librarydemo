package org.dxc.book.controller;

import java.util.List;
import java.util.Optional;

import org.dxc.book.model.Book;
import org.dxc.book.repository.BookRepository;
import org.dxc.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BookController {

	@Autowired
	BookRepository bookRepository;
    @Autowired
    BookService bookService;
	@RequestMapping("/getbooks")
	public List<Book> getBooks() {
		return bookService.findAll();
		
	}

	@GetMapping(value = "/getbook/{id}")
	public Optional<Book> findById(@PathVariable int id) {
		return bookService.getById(id);
	}

	@GetMapping(value = "/details/{publisher}")
	public List<Book> findByPublisher(@PathVariable String publisher) {
		return bookService.getByPublisher(publisher);
		
	}

	@DeleteMapping(value = "/delete/{bookid}")
	public void deleteById(@PathVariable int bookid) {
		bookService.delete(bookid);
		

	}

	// @PostMapping(value = "/savebook")
	// public List<Book> persist(@RequestBody final Book book) {
	// bookRepository.save(book);
	// return bookRepository.findAll();

	// }

	@PostMapping(value = "/savebook")
	public HttpStatus saveBook(@RequestBody Book book) {
		HttpStatus status=bookService.saveBook(book);
		return status;
	}
	
	@PutMapping(value ="/update")
	public String update(@RequestBody Book book) {
		String status=bookService.updateBook(book);
		return status;

}
	@GetMapping(value = "/authorname/{authorname}")
	public List<Book> findByAuthorName(@PathVariable String authorname){
		return bookService.getByAuthorName(authorname);
	
	}
	@GetMapping(value = "/catagory/{catagory}")
	public List<Book> findByCatagory(@PathVariable String catagory){
		return bookService.getByCatagory(catagory);
	
	}
	
	
	
	
}
