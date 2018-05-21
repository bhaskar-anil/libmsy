package com.libmsy.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libmsy.data.BookData;
import com.libmsy.data.BookTrie;
import com.libmsy.data.UserData;
import com.libmsy.domain.Book;
import com.libmsy.domain.User;
import com.libmsy.service.intf.LibraryServiceInterface;

@Service
public class LibraryService implements LibraryServiceInterface{
	
	@Autowired
	private BookData bookData;
	
	@Autowired
	private UserData userData;

	@Override
	public boolean addBook(Book book) {
		//do the business logic here
		//validate isbn or title or author
		return bookData.add(book);
	}
	
	@Override
	public void addUser(User user) {
		userData.add(user);
	}

	/**
	 * @description 	method for lend book action for given user
	 * 				checks if book available
	 * 				checks if user has not crossed limit and can lend a book
	 * 				decrease the book stock
	 * 				decrease the limit left for the user
	 * 				adds book into user's books' list
	 * 
	 * @param isbn ISBN number of the book
	 * @param rollNo user id
	 * 
	 * 
	 */
	@Override
	public String lendBook(Integer isbn, Integer rollNo) {
		Book book = bookData.findByISBN(isbn);
		if(book == null) {
			return "Book not found with ISBN:"+isbn;
		}
		
		if(book.getStock() == 0) {
			return "Stock not available for book:"+isbn;
		}
		
		User user  = userData.findByRollNo(rollNo);
		
		if(user == null) {
			return "User not found with rollNo:"+rollNo;
		}

		if(userData.findByRollNo(rollNo).getLimit() == 0) {
			return "User has crossed the limit.";
		}

		bookData.decreaseStockByOne(isbn);
		userData.lendBook(rollNo, isbn);
		return "Success!";	
	}

	public String setLimit(Integer rollNo, Integer limit) {
		return userData.setLimit(rollNo, limit);
	}

	public List<User> findAllUsers() {
		return userData.findAll();
	}

	public List<Book> findAllBooks() {
		return bookData.findAll();
	}
	
	public static void main(String[] args) {
		BookTrie bookTrie = new BookTrie();
		bookTrie.insert("Hello");
		bookTrie.insert("Hello world");
		bookTrie.insert("Hello there world");
		
		bookTrie.search("Hello");
	}

	public String returnBook(Integer isbn, Integer rollNo) {
		Book book = bookData.findByISBN(isbn);
		if(book == null) {
			return "Book not found with ISBN:"+isbn;
		}
		
		User user  = userData.findByRollNo(rollNo);
		
		if(user == null) {
			return "User not found with rollNo:"+rollNo;
		}
		
		if(!user.getBooks().contains(isbn)) {
			return "User does not having this book.";
		}
		
		bookData.returnBook(isbn);
		userData.returnBook(rollNo, isbn);
		return "Success!";
	}

}
