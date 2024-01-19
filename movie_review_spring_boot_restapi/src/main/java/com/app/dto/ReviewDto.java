package com.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReviewDto{
	
	@JsonProperty(access = Access.READ_ONLY)
	private Integer id;
	private String review;
	private Integer rating;
//	private Timestamp modified;
	private Integer movieId;
	private Integer userId;
	
}
