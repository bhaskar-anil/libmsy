package com.libmsy.domain;

public class Book {
	
	private Integer isbn;
	private String title;
	private String author;
	transient boolean availability;
	private Integer stock;
	
	private Book(Integer isbn, String title, String author, boolean availability, Integer stock) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.availability = availability;
		this.stock = stock;
	}
	
	public static BookBuilder BookBuilder() {
		return new BookBuilder();
	}
	
	public Integer getIsbn() {
		return isbn;
	}
	
	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public boolean isAvailability() {
		return availability;
	}
	
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	
	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public static class BookBuilder{
		private Integer isbn;
		private String title;
		private String author;
		private boolean availability;
		private Integer stock;
		
		public BookBuilder setIsbn(Integer isbn) {
			this.isbn = isbn;
			return this;
		}
		
		public BookBuilder setTitle(String title) {
			this.title = title;
			return this;
		}
		
		public BookBuilder setAuthor(String author) {
			this.author = author;
			return this;
		}
		
		public BookBuilder setAvailability(boolean  availability) {
			this.availability = availability;
			return this;
		}
		
		public BookBuilder setStock(Integer  stock) {
			this.stock = stock;
			return this;
		}
		
		public Book createBook() {
			return new Book(isbn, title, author, availability, stock);
		}
	}
}
