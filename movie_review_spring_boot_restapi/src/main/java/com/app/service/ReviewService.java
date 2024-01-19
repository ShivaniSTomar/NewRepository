package com.app.service;

import com.app.dto.ResponseReviewDto;
import com.app.dto.ReviewDto;

public interface ReviewService {

	//list review for given id
	ResponseReviewDto getReview(Integer reviewId);

	//method/api to remove review
	String removeReview(Integer reviewId);

	//method to update review by id
	String modifyReview(Integer reviewId, ReviewDto reviewDto);

	//mtd to add new review
	String addNewReview(ReviewDto reviewDto);
	
}
