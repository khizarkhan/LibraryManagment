package com.starter;

import java.util.ArrayList;
import java.util.List;

import com.vo.Books;

public class JDk8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Books b1= new Books();
		b1.setName("khan");
		
		Books b2= new Books();
		b2.setName("khan-1");
		
		Books b3= new Books();
		b3.setName("khan-2");
		
		List<Books> b=new ArrayList<Books>();
		b.add(b1);
		b.add(b2);
		b.add(b3);
		b.stream().sorted((e1,e2)->e2.getName().compareTo(e1.getName())).forEach((e)->System.out.print(e.getName()));

	}

}
