package com.libmsy.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.libmsy.domain.User;

@Component
public class UserData {
	
	private Map<Integer, User> userMap = new HashMap<>();
	
	public User findByRollNo(Integer rollNo) {
		return userMap.get(rollNo);
	}
	
	public void add(User user) {
		if(userMap.put(user.getRollNo(), user) != null) {
			//throw exception UserAlreadyExistsException
		}
	}
	
	public List<User> findAll(){
		return new ArrayList<User>(userMap.values());
	}
	

	public String setLimit(Integer rollNo, Integer limit) {
		User saved = findByRollNo(rollNo);
		if(saved != null) {
			saved.setLimit(limit);
			userMap.put(rollNo, saved);
			return "Limit set for user:"+rollNo;
		}
		return "User not found with rollNo:"+rollNo;
		
	}

	public void lendBook(Integer rollNo, Integer isbn) {
		User saved = findByRollNo(rollNo);
		//no null check, already checked
		saved.lendBook(isbn);
		saved.setLimit(saved.getLimit()-1);
		userMap.put(rollNo, saved);
	}

	public void returnBook(Integer rollNo, Integer isbn) {
		User saved = findByRollNo(rollNo);
		saved.returnBook(isbn);
		saved.setLimit(saved.getLimit()+1);
		userMap.put(rollNo, saved);
	}

}
