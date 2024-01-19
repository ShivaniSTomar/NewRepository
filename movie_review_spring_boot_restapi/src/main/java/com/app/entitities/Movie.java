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
@Table(name="movies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Movie extends BaseEntity{
	/*
	 * title VARCHAR(40) UNIQUE,
	rel_date DATE*/
	
	@Column(name="movie_title", unique = true, length=40)
	private String title;
	
	@Column(name="rel_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate releaseDate;
	
//	@OneToMany(mappedBy="movie")
//	Set<Review> reviews = new HashSet<>();
}
