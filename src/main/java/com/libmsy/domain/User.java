package com.libmsy.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private Integer rollNo;
	private String name;
	private String email;
	private List<Integer> books  = new ArrayList<>();
	private Integer limit = 0;
	
	public User(Integer rollNo, String name, String email, Integer limit) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.email = email;
		this.limit = limit;
	}
	public Integer getRollNo() {
		return rollNo;
	}
	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Integer> getBooks() {
		return books;
	}
	public void lendBook(Integer isbn) {
		this.books.add(isbn);
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public void returnBook(Integer isbn) {
		this.books.remove(isbn);
	}
}
