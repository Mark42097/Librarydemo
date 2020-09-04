package org.dxc.book.repository;

import java.util.List;

import org.dxc.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
@EnableJpaRepositories
public interface BookRepository extends JpaRepository<Book,Integer>{
	@Query("SELECT b FROM Book b WHERE b.publisher=:publisher")
	public List<Book> findByPublisher(@Param("publisher")String publisher);
	@Query("SELECT b FROM Book b WHERE b.authorname=:authorname")
	public List<Book> findByAuthorName(@Param("authorname")String authorname);
	@Query("SELECT b FROM Book b WHERE b.catagory=:catagory")
	public List<Book> findByCatagory(@Param("catagory")String catagory);
	
	
}
