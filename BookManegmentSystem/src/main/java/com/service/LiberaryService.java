package com.service;

import java.util.List;

import com.vo.Books;
import com.vo.Liberary;

public interface LiberaryService {
	List<Books> getAllBooks(Long id);
	void updateBookDetails(int id, String name);
	List<Liberary> getAllLibrary();

}
