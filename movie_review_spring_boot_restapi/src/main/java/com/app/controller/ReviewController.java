package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.custom_exception.ResourceNotFoundExeception;
import com.app.dto.ApiResponse;
import com.app.dto.ReviewDto;
import com.app.service.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping("/{reviewId}")
	public ResponseEntity<?> getReview(@PathVariable Integer reviewId){
		try {
			return ResponseEntity.ok(reviewService.getReview(reviewId));
		}catch(ResourceNotFoundExeception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity<?> addReview(@RequestBody ReviewDto reviewDto){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(reviewService.addNewReview(reviewDto)));
		}
		catch(ResourceNotFoundExeception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@PutMapping("/{reviewId}")
	public ResponseEntity<?> updateReview(@PathVariable Integer reviewId, @RequestBody ReviewDto reviewDto){
		try {
		return ResponseEntity.ok(new ApiResponse(reviewService.modifyReview(reviewId, reviewDto)));
		}catch(ResourceNotFoundExeception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@DeleteMapping("/{reviewId}")
	public ResponseEntity<?> removeReview(@PathVariable Integer reviewId){
		try {
			return ResponseEntity.ok(new ApiResponse(reviewService.removeReview(reviewId)));
			}catch(ResourceNotFoundExeception e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
			}
	}
}
