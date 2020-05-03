package com.vo;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Liberary")
public class Liberary {
	private Long id;
	private String name;
	private Set<Books>book;
	
	public Liberary() {
		// TODO Auto-generated constructor stub
	}
	
	public Liberary(int id,String string) {
		// TODO Auto-generated constructor stub
	}
	public Liberary(Long id, String name, Set<Books> book) {
		super();
		this.id = id;
		this.name = name;
		this.book = book;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@OneToMany(mappedBy = "library", cascade = CascadeType.ALL)
	public Set<Books> getBook() {
		return book;
	}
	
	
	public void setBook(Set<Books> book) {
		this.book = book;
	}
	

}
