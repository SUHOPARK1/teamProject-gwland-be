package com.tplus.gwland.rev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tplus.gwland.cmm.service.AbstractService;
import com.tplus.gwland.pce.repository.PlaceRepository;
import com.tplus.gwland.rev.domain.Review;
import com.tplus.gwland.rev.domain.ReviewDto;
import com.tplus.gwland.rev.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
	
	private final ReviewRepository repo;
	
	private final PlaceRepository pceRepo;

	public long save(ReviewDto r) {
		System.out.println(r);
		return (repo.save(toEntity(r)) != null) ? 1 : 0; }

	public long delete(Review t) {repo.delete(t); return (getOne(t.getRevNum()) == null) ? 1 : 0;}

	public long count() {return (long)repo.count();}

	public Review getOne(long id) {return repo.getOne(id);}

	public Optional<Review> findById(long id) {return repo.findById(id);}

	public boolean existsById(long id) {return repo.existsById(id);}

	public List<Review> findAll() { return repo.findAll();}
	
	public List<ReviewDto> findList() {return repo.findList();}
	
	public List<ReviewDto> findRevByPceConentId(long contentid) {
				    return repo.findRevByPceConentId(contentid); }
	
	public Review toEntity(ReviewDto r) {
		return Review.builder()
				.revNum(r.getRevNum())
				.revName(r.getRevName())
				.revStar(r.getRevStar())
				.revContent(r.getRevContent())
				.revDate(r.getRevDate())
				.place(pceRepo.getOne(r.getContentid()))
				.build();
	}
}
