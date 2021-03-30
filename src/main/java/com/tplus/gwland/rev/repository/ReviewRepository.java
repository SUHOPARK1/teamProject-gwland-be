package com.tplus.gwland.rev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tplus.gwland.rev.domain.Review;
import com.tplus.gwland.rev.domain.ReviewDto;

interface ReviewCustomRepository{
	public List<Review> findByRevName(String revName);
	public List<ReviewDto> findList();
}

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewCustomRepository {
	
}

