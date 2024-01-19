package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entitities.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer>{

	boolean existsByMovieId(Integer movieId);

	boolean existsByUserId(Integer userId);
	
}
