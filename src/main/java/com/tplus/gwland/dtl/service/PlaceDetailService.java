package com.tplus.gwland.dtl.service;


import java.util.List;

import com.tplus.gwland.dtl.domain.PlaceDetail;

public interface PlaceDetailService {
    public List<PlaceDetail> findByContentid(String contentid);
}
