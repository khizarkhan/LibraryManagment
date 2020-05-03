package com.controller;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dto.BookDto;
import com.service.LiberaryService;
import com.vo.Books;
import com.vo.Liberary;

@RestController
@CrossOrigin("http://localhost:4200")
public class LiberaryController {
@Autowired
LiberaryService liberaryService;

@Autowired
private ModelMapper modelMapper;

@RequestMapping(method = RequestMethod.GET, value = "/getBook/{id}")
public List<BookDto> getAllBooks(@PathVariable ("id") Integer id){
	List<Books> books = liberaryService.getAllBooks(new Long(id));
	List<BookDto> postDtoList = Arrays.asList(modelMapper.map(books, BookDto[].class));
	//List<BookDto> bookDto = modelMapper.map(books, new TypeToken<List<BookDto>>(){}.getType());
	return postDtoList;
	
}


@RequestMapping(method = RequestMethod.GET, value = "/getLibrary")
public List<BookDto> getAllLibrary(){
	List<Liberary> library = liberaryService.getAllLibrary();
	List<BookDto> postDtoList = Arrays.asList(modelMapper.map(library, BookDto[].class));
	//List<BookDto> bookDto = modelMapper.map(books, new TypeToken<List<BookDto>>(){}.getType());
	return postDtoList;
	
}

@RequestMapping(method = RequestMethod.GET, value = "/update/{id}/{name}")
public List<BookDto> getAllBooks1(@PathVariable ("id") Integer id, @PathVariable ("name") String name){
	liberaryService.updateBookDetails(id,name);
	return getAllBooks(1);
	
}

@Bean
public ModelMapper modelMapper() {
   ModelMapper modelMapper = new ModelMapper();
   return modelMapper;
}


}
