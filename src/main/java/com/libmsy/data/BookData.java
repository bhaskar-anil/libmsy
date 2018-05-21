package com.libmsy.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.libmsy.domain.Book;

/**
 * 
 * @author anil.bhaskar
 * 
 * @description 	Data layer for book data structure to store the book data
 * 				A HashMap of Book ISBN number to allow O(1) lookup for ISBN
 * 				A Trie data structure for title to allow lookup in O(1) or O(K)
 * 				A Trie data structure for author to allow lookup in O(1) or O(K)
 *
 */
@Component
public class BookData {
	private Map<Integer, Book> booksMap = new HashMap<>();
	
	/**
	 * find book if available or returns null
	 * 
	 * @param isbn
	 * @return
	 */
	public Book findByISBN(Integer isbn) {
		return booksMap.get(isbn);
	}
	
	public Map<Integer, Book> getBooksMap(){
		return this.booksMap;
	}
	
	public boolean add(Book book) {
		//if isbn already there increase stock
		Book saved = findByISBN(book.getIsbn());
		if(saved != null) {
			book.setStock(book.getStock()+saved.getStock());
		}
		booksMap.put(book.getIsbn(), book);
		return true;
	}
	
	public List<Book> getAll(){
		return new ArrayList<Book>(booksMap.values());
	}

	public void decreaseStockByOne(Integer isbn) {
		Book saved = findByISBN(isbn);
		//no null check required we already checked
		saved.setStock(saved.getStock()-1);
		booksMap.put(isbn, saved);
	}

	public List<Book> findAll() {
		return new ArrayList<Book>(booksMap.values());
	}

	public void returnBook(Integer isbn) {
		Book saved = findByISBN(isbn);
		//no null check required we already checked
		saved.setStock(saved.getStock()+1);
		booksMap.put(isbn, saved);
	}

}
