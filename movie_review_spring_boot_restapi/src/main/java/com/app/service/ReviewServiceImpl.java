package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundExeception;
import com.app.dao.MovieRepository;
import com.app.dao.ReviewRepository;
import com.app.dao.UserRepository;
import com.app.dto.ResponseReviewDto;
import com.app.dto.ReviewDto;
import com.app.entitities.Movie;
import com.app.entitities.Review;
import com.app.entitities.User;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService{
	@Autowired
	private ReviewRepository reviewRepo;
	
	@Autowired
	private MovieRepository movieRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public ResponseReviewDto getReview(Integer reviewId) {
		Review review = reviewRepo.findById(reviewId).orElseThrow(()->new ResourceNotFoundExeception("Invalid Review id"));
		return mapper.map(review, ResponseReviewDto.class);
	}

	@Override
	public String removeReview(Integer reviewId) {
		Review review = reviewRepo.findById(reviewId).orElseThrow(()->new ResourceNotFoundExeception("Review id doesn't exist"));
		reviewRepo.delete(review);
		return "review deleted";
	}

	@Override
	public String modifyReview(Integer reviewId, ReviewDto reviewDto) {
		Review review = reviewRepo.findById(reviewId).orElseThrow(()->new ResourceNotFoundExeception("Review id doesn't exist"));
		Integer movieId = reviewDto.getMovieId();
		Integer userId = reviewDto.getUserId();
		Movie movie = movieRepo.findById(movieId).orElseThrow(()->new ResourceNotFoundExeception("Movie id doesn't exist"));
		User user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundExeception("User id doesn't exist"));
		mapper.map(reviewDto, review); //after this review id is null so set it again to the id passed as parameter
		review.setId(reviewId);
		reviewRepo.save(review);
		return "review updated";
	}

	@Override
	public String addNewReview(ReviewDto reviewDto) {
		Integer movieId = reviewDto.getMovieId();
		Integer userId = reviewDto.getUserId();
		//System.out.println("movie id: " + movieId+"user id:"+userId);
		Movie movie = movieRepo.findById(movieId).orElseThrow(()->new ResourceNotFoundExeception("Movie id doesn't exist"));
		User user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundExeception("User id doesn't exist"));
		if(reviewRepo.existsByMovieId(movieId) && reviewRepo.existsByUserId(userId))
			throw new ResourceNotFoundExeception("Review already given");
		Review review = mapper.map(reviewDto, Review.class);
		review.setMovie(movie);
		review.setUser(user);
	    System.out.println("review: " + review);
		Review persistentReview = reviewRepo.save(review);
		if(persistentReview != null)
			return "New Review Added";
		return "Review is not Added";
	}

}
