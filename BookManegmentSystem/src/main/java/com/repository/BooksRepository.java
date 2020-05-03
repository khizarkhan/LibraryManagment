package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vo.Books;

@Repository
public interface BooksRepository extends  CrudRepository<Books, Long> {

	@Query(value = "SELECT id,name FROM BOOKS ", nativeQuery = true)
	List<Books> findByLibId(@Param ("id") Integer id);

}
