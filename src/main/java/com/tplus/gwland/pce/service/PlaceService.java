package com.tplus.gwland.pce.service;



import java.util.List;

import com.tplus.gwland.pce.domain.Place;
import com.tplus.gwland.pce.domain.PlaceDto;

public interface PlaceService {
	public List<Place> findByContentidAndTitle(String contentid, String title);

	public List<Place> findByContenttypeid(String contenttypeid);

	public int update(String tel, long pceNum);

	public List<Place> findByContentid(long contentid);

	public List<PlaceDto> findByList();

}
