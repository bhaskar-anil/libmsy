package com.libmsy.service.intf;

import org.springframework.stereotype.Service;

import com.libmsy.domain.Book;
import com.libmsy.domain.User;


@Service
public interface LibraryServiceInterface {
	
	boolean addBook(Book book); //may throw BookAlreadyExists
	
	void addUser(User user); //may throw UserAlreadyExists
	
	String lendBook(Integer isbn, Integer rollNo); //may throws BookNotFoundException, UserNotFoundException, BookLimitExceededException

}
