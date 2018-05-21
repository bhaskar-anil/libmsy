package com.libmsy;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.libmsy.controller.LibraryController;
import com.libmsy.service.LibraryService;

@RunWith(SpringRunner.class)
@WebMvcTest(LibraryController.class)
public class ControllerTest {
	
	@Autowired
    private MockMvc mvc;
	
	@MockBean
	private LibraryService libraryService;
	
	@Test
	public void shouldAddBook() throws Exception {
		mvc.perform(post("/books/add")
				.param("isbn", "1")
				.param("title", "Introduction to Algorithms")
				.param("author", "Cormen")
				.param("availability", "true")
				.param("stock", "1")).andExpect(redirectedUrl("/books")).andExpect(status().is(302));
	}
	
	@Test
	public void shouldAddUser() {
		
	}
	
	@Test
	public void shouldSetUserBookLimit() {
		
	}
	
	@Test
	public void shouldLenDBook() {
		
	}
	
	@Test
	public void shouldReturnBook() {
		
	}

}
