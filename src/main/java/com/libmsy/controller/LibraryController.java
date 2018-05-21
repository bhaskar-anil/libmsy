package com.libmsy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.libmsy.domain.Book;
import com.libmsy.domain.User;
import com.libmsy.service.LibraryService;

@RestController
public class LibraryController {
	
	@Autowired
	private LibraryService libraryService;
	
	/* ---------------------Book related URIs------------------------ */
	@RequestMapping(value = { "/books" }, method = RequestMethod.GET)
	public ResponseEntity<List<Book>> findAllBooks(){
		return new ResponseEntity<List<Book>>(libraryService.findAllBooks(), HttpStatus.OK);
	}
	
	@RequestMapping(value = { "/books/add" }, method = RequestMethod.POST)
	public void addBook(@RequestParam("isbn") Integer isbn, @RequestParam("title") String title,
			@RequestParam("author") String author, @RequestParam("availability") boolean availability, 
			@RequestParam("stock") Integer stock, HttpServletResponse response) throws IOException{
		Book book = Book.BookBuilder()
				.setIsbn(isbn)
				.setAuthor(author)
				.setTitle(title)
				.setTitle(title)
				.setStock(stock).createBook();
		libraryService.addBook(book);
		response.sendRedirect("/books");
	}
	
	@RequestMapping(value = { "/books/lend/{isbn}" }, method = RequestMethod.POST)
	public ResponseEntity<String> lendBook(@PathVariable("isbn") Integer isbn, @RequestParam("rollNo") Integer rollNo)
			throws IOException{
		return new ResponseEntity<>(libraryService.lendBook(isbn, rollNo), HttpStatus.OK);
	}
	
	@RequestMapping(value = { "/books/return/{isbn}" }, method = RequestMethod.POST)
	public ResponseEntity<String> returnBook(@PathVariable("isbn") Integer isbn, @RequestParam("rollNo") Integer rollNo){
		return new ResponseEntity<>(libraryService.returnBook(isbn, rollNo), HttpStatus.OK);
	}
	
	
	
	/* ---------------------User related URIs------------------------ */
	
	@RequestMapping(value = { "/users" }, method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAllUsers(){
		return new ResponseEntity<List<User>>(libraryService.findAllUsers(), HttpStatus.OK);
	}
	
	@RequestMapping(value = { "/users/add" }, method = RequestMethod.POST)
	public void addUser(@RequestParam("rollNo") Integer rollNo, @RequestParam("name") String name, 
			@RequestParam("email") String email, HttpServletResponse response) throws IOException{
		User user =  new User(rollNo, name, email, 0);
		libraryService.addUser(user);
		response.sendRedirect("/users");
	}
	
	@RequestMapping(value = { "/users/{rollNo}/setlimit" }, method = RequestMethod.POST)
	public ResponseEntity<String> setBookLimit(@PathVariable("rollNo") Integer rollNo, @RequestParam("limit") Integer limit){
		return new ResponseEntity<>(libraryService.setLimit(rollNo, limit), HttpStatus.OK);
	}
	
	

}
