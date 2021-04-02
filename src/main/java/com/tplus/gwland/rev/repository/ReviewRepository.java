package com.tplus.gwland.rev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tplus.gwland.rev.domain.Review;
import com.tplus.gwland.rev.domain.ReviewDto;

interface ReviewCustomRepository{
	public List<Review> findByRevName(String revName);
	public List<ReviewDto> findList();
	public List<ReviewDto> findRevByPceConentId(long contentid);
	public List<ReviewDto> delete();
}

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewCustomRepository {


	
}

