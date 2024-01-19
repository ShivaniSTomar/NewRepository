package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entitities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
}
