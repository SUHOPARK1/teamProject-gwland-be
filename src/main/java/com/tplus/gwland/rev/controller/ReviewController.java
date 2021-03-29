package com.tplus.gwland.rev.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tplus.gwland.cmm.controller.AbstractController;
import com.tplus.gwland.rev.domain.Review;
import com.tplus.gwland.rev.service.ReviewServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RequiredArgsConstructor
@RequestMapping("/review")

public class ReviewController extends AbstractController<Review>{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	final ReviewServiceImpl reviewService;
	
	@PostMapping("/save")
	public ResponseEntity<Long> save(@RequestBody Review t) {
		System.out.println(t.getRevContent());
		logger.info(t.getRevContent());
		return ResponseEntity.ok(reviewService.save(t));
	}
	@DeleteMapping("/delete")
	public ResponseEntity<Long> delete(@RequestBody Review t) {
		return ResponseEntity.ok(reviewService.delete(t));
	}
	@GetMapping("/count")
	public ResponseEntity<Long> count() {
		return ResponseEntity.ok(reviewService.count());
	}
	@GetMapping("/findAll")
	public ResponseEntity<List<Review>> findAll() {
		return ResponseEntity.ok(reviewService.findAll());
	}
	@GetMapping("/one/{id}")
	public ResponseEntity<Review> getOne(@PathVariable long id) {
		return ResponseEntity.ok(reviewService.getOne(id));
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<Optional<Review>> findById(@PathVariable long id) {
		return ResponseEntity.ok(reviewService.findById(id));
	}
	@GetMapping("/exists/{id}")
	public ResponseEntity<Boolean> existsById(@PathVariable long id) {
		return ResponseEntity.ok(reviewService.existsById(id));
	}
	
	
}
