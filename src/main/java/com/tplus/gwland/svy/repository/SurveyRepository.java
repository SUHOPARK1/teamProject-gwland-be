
package com.tplus.gwland.svy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tplus.gwland.svy.domain.Survey;

interface ISurveyRepository {

}

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Integer>, ISurveyRepository {

}