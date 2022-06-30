package com.library.application.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.library.application.entities.Review;
import com.library.application.entities.UserLogin;

public interface Reviewrepo extends CrudRepository<Review, String> {

	@Query("from Review where sno=:code")
	public Review findByCode(@Param("code") Integer id);
	
	@Query("from Review where productCode=:code and status=false")
	public Iterable<Review> findByProductCode(@Param("code") String id);

	@Query("from Review where productCode=:code and status=true")
	public Iterable<Review> findByStat(@Param("code") String id);

}
