package com.tplus.gwland.dtl.service;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.tplus.gwland.cmm.service.AbstractService;
import com.tplus.gwland.dtl.domain.PlaceDetail;
import com.tplus.gwland.dtl.repository.PlaceDetailRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlaceDetailServiceImpl extends AbstractService<PlaceDetail> implements PlaceDetailService{
    private final PlaceDetailRepository repo;

    @Override public long save(PlaceDetail t) {
        return (repo.save(t) != null) ? 1 : 0;
    }

    @Override public long delete(PlaceDetail t) {
        repo.delete(t);
        return (getOne(t.getDtlNum()) == null) ? 1 : 0;
    }

    @Override public long count() {
        return (int) repo.count();
    }

    @Override public PlaceDetail getOne(long id) {
        return repo.getOne(id);
    }

    @Override public Optional<PlaceDetail> findById(long id) {
        return repo.findById(id);
    }

    @Override public boolean existsById(long id) {
        return repo.existsById(id);
    }

    @Override public List<PlaceDetail> findAll() {
        return repo.findAll();
    }

    @Override
    public List<PlaceDetail> findByContentid(String contentid) {
        return repo.findByContentid(contentid);
    }
}

