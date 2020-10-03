package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@GetMapping("/getbook")
	public Book getHello() {
		return new Book("Mahabharata", 123);
	}

	@GetMapping("/getbookall")
	public List<Book> getHello1() {
		List<Book> booklist = new ArrayList<Book>();
		booklist.add(new Book("Mahabharata", 123));
		booklist.add(new Book("Ramayana", 230));
		return booklist;
	}
	
}
