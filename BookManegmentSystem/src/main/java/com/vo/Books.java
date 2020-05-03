package com.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Books")
public class Books {
	private int id;
	private String name;
	private Liberary library;
	@ManyToOne
	@JoinColumn
	public Liberary getLibrary() {
		return library;
	}
	
	public Books(int id, String name, Liberary library) {
		super();
		this.id = id;
		this.name = name;
		this.library = library;
	}

	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Books(String string, Liberary categoryA) {
		// TODO Auto-generated constructor stub
	}

	public void setLibrary(Liberary library) {
		this.library = library;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	@Column
	public void setName(String name) {
		this.name = name;
	}
	

}
