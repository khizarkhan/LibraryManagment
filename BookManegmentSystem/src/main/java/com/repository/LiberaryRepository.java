package com.repository;

import java.util.List;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vo.Books;
import com.vo.Liberary;

@Repository
public interface LiberaryRepository extends CrudRepository<Liberary, Long>{
	@Modifying
	@Transactional
	@Query(value = "update Books b set b.name=:name where  b.id=:id", nativeQuery = true)
	void updateBook(@Param("id")Integer id, @Param("name") String name);
	
	

}
