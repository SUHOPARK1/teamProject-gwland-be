package com.tplus.gwland.rev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tplus.gwland.cmm.service.AbstractService;
import com.tplus.gwland.rev.domain.Review;
import com.tplus.gwland.rev.domain.ReviewDto;
import com.tplus.gwland.rev.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl extends AbstractService<Review> implements ReviewService {
	private final ReviewRepository repo;

	@Override
	public long save(Review r) {return (repo.save(r) != null) ? 1 : 0;}

	@Override
	public long delete(Review r) {repo.delete(r); return (getOne(r.getRevNum()) == null) ? 1 : 0;}

	@Override
	public long count() {return (long)repo.count();}

	@Override
	public Review getOne(long id) {return repo.getOne(id);}

	@Override
	public Optional<Review> findById(long id) {return repo.findById(id);}

	@Override
	public boolean existsById(long id) {return repo.existsById(id);}

	
	public List<ReviewDto> findList() {return repo.findList();}

	@Override
	public List<Review> findAll() { return repo.findAll();}

	}
