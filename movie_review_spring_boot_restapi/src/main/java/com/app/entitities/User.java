package com.app.entitities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity{
	/*
	 * id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(20),
last_name VARCHAR(20),
email VARCHAR(40) UNIQUE,
mobile CHAR(12),
dob DATE,
password VARCHAR(100)
	 */
	@Column(name="first_name", length=20)
	private  String firstName;
	
	@Column(name="last_name", length=20)
	private  String lastName;
	
	@Column(name="email", length=40)
	private  String email;
	
	@Column(name="mobile", length=12)
	private  String mobile;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private  LocalDate dob;
	
	@Column(length=100)
	private  String password;
	
//	@OneToMany(mappedBy="movie")
//	Set<Review> reviews = new HashSet<>();
}
