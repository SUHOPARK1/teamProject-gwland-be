package com.tplus.gwland.pce.domain;

import static com.tplus.gwland.pce.domain.QPlace.place;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@Lazy
@NoArgsConstructor
public class PlaceDto {
	private long contentid;
	private String addr1;
	private String addr2;
	private String areacode;
	private String cat1;
	private String cat2;
	private String cat3;
	private String contenttypeid;
	private String createdtime;
	private String firstimage;
	private String firstimage2;
	private String mapx;
	private String mapy;
	private String mlevel;
	private String modifiedtime;
	private String readcount;
	private String sigungucode;
	private String tel;
	private String title;
	private String zipcode;
	private String overview;
	public PlaceDto(long contentid, String firstimage, String title, String overview) {
		super();
		this.contentid = contentid;
		this.firstimage = firstimage;
		this.title = title;
		this.overview = overview;
	}
}