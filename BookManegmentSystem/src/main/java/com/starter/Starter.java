package com.starter;



import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.repository.LiberaryRepository;
import com.vo.Books;
import com.vo.Liberary;

@SpringBootApplication
@EnableJpaRepositories("com.*")
@EntityScan("com.*")
@ComponentScan("com.*")

public class Starter implements CommandLineRunner {

	@Autowired
	LiberaryRepository repo;
	public static void main(String[] args) {
		SpringApplication.run(Starter.class, args);
	}

	 @Transactional
	    public void run(String... strings) throws Exception {
	        // save a couple of categories
	        
		 final Liberary categoryA = new Liberary(1,"Liberay A");
		 categoryA.setId(new Long(1));
	        Set<Books> bookAs = new HashSet<Books>();
	        Books b1= new Books("Book A1", categoryA);
	        b1.setName("Book A1");
	        b1.setLibrary(categoryA);
	        Books b2= new Books("Book A1", categoryA);
	        b2.setName("Book A2");
	        b2.setLibrary(categoryA);
	        bookAs.add(b2);
	        bookAs.add(b1);
	       
	        categoryA.setBook(bookAs);
	        
	        categoryA.setName("Library A");

	        final Liberary categoryB = new Liberary(2,"Liberay B");
	        categoryB.setId(new Long(2));
	        Books b3= new Books("Book B1", categoryB);
	        b3.setName("Book B1");
	        b3.setLibrary(categoryB);
	        Books b4= new Books("Book B1", categoryB);
	        b4.setName("Book b2");
	        b4.setLibrary(categoryB);
	        Set<Books> bookBs = new HashSet<Books>();
	        bookBs.add(b3);
	        bookBs.add(b4);
	        //bookBs.add(new Books("Book B3", categoryB));
	        categoryB.setBook(bookBs);
	        categoryB.setName("Library B");
	       

	       repo.saveAll(Arrays.asList(categoryA,categoryB));

	        // fetch all categories
	       

}
	 
}
