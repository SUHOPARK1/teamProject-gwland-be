package com.tplus.gwland.dtl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tplus.gwland.dtl.domain.PlaceDetail;

interface IPlaceDetailRepository {
    public List<PlaceDetail> findByContentid(String contentid);
}
public interface PlaceDetailRepository extends JpaRepository<PlaceDetail, Long>, IPlaceDetailRepository {

}