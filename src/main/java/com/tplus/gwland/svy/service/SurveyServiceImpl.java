package com.tplus.gwland.svy.service;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tplus.gwland.svy.domain.Survey;
import com.tplus.gwland.svy.repository.SurveyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService {
    private final SurveyRepository repo;

    public int save(Survey s) {
        return repo.save(s) != null ? 1 : 0;
    }

    public Survey getOne(int id) {
        return repo.getOne(id);
    }

    public int delete(Survey s) {
        repo.delete(s);
        return existsById(s.getSvyNum()) ? 0 : 1;
    }

    public int count() {
        return (int) repo.count();
    }

    public Boolean existsById(int id) {
        return repo.existsById(id);
    }

    public List<Survey> findAll() {
        return repo.findAll();
    }

    public Page<Survey> findList(Pageable pageable) {
        return repo.findAll(pageable);
    }
}