package com.tplus.gwland.pce.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;

import com.tplus.gwland.cmm.service.AbstractService;
import com.tplus.gwland.pce.domain.Place;
import com.tplus.gwland.pce.domain.PlaceDto;
import com.tplus.gwland.pce.repository.PlaceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlaceServiceImpl extends AbstractService<Place> implements PlaceService {

	private final PlaceRepository repo;

	@Override
	public long save(Place t) {
		return (repo.save(t) != null) ? 1 : 0;
	}

	public long saveAll(List<Place> t) {
		return (repo.saveAll(t) != null) ? 1 : 0;
	}

	@Override
	public long delete(Place t) {
		repo.delete(t);
		return (getOne(t.getContentid()) == null) ? 1 : 0;
	}

	@Override
	public long count() {
		return (int) repo.count();
	}

	public Place getOne(long id) {
		return repo.getOne(id);
	}

	@Override
	public Optional<Place> findById(long id) {
		return repo.findById(id);
	}

	@Override
	public boolean existsById(long id) {
		return repo.existsById(id);
	}

	@Override
	public List<Place> findAll() {
		return repo.findAll();
	}

	@Override
	public int update(String tel, long contentid) {
		return repo.update(tel, contentid);
	}

	@Override
	public List<Place> findByContentidAndTitle(String contentid, String title) {
		return repo.findByContentidAndTitle(contentid, title);
	}

	@Override
	public List<Place> findByContenttypeid(String contenttypeid) {
		return repo.findAll().stream().filter(place -> place.getContenttypeid().equals(contenttypeid))
				.collect(Collectors.toList());
	}

	@Override
	public List<Place> findByContentid(long contentid) {
		return repo.findByContentid(contentid);
	}

	@Override
	public List<PlaceDto> findByList() {
		return repo.findByList();
	}

}