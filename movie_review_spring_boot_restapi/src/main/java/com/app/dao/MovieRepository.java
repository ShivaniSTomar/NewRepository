package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entitities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{
	
}
