package com.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repository.BooksRepository;
import com.repository.LiberaryRepository;
import com.vo.Books;
import com.vo.Liberary;

@Service
public class LiberaryServiceImpl implements LiberaryService {
	
	@Autowired
	LiberaryRepository liberaryRepo;
	
	@Autowired
	BooksRepository bookRepos;
	List<Books> books=null;

	public List<Books> getAllBooks(Long id) {
		books= new ArrayList<Books>();
		try {
		Optional<Liberary> optional = liberaryRepo.findById(id);
		
		Set<Books> bookSet =  optional.get().getBook();
		books.addAll(bookSet);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}

	public void updateBookDetails(int id, String name) {
		liberaryRepo.updateBook(id,  name);
		
	}

	public List<Liberary> getAllLibrary() {
		// TODO Auto-generated method stub
		return (List<Liberary>) liberaryRepo.findAll();
	}

}
