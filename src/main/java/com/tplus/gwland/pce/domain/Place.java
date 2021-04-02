package com.tplus.gwland.pce.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.tplus.gwland.dtl.domain.PlaceDetail;
import com.tplus.gwland.rev.domain.Review;

import lombok.Getter;
import lombok.ToString;

@Entity @Getter @ToString @Table(name ="place")
public class Place {
    @Id @Column(name="contentid") private long contentid;
    @Column(name="addr1") private String addr1;
    @Column(name="addr2") private String addr2;
    @Column(name="areacode") private String areacode;
    @Column(name="cat1") private String cat1;
    @Column(name="cat2") private String cat2;
    @Column(name="cat3") private String cat3;
    @Column(name="contenttypeid") private String contenttypeid;
    @Column(name="createdtime") private String createdtime;
    @Column(name="firstimage") private String firstimage;
    @Column(name="firstimage2") private String firstimage2;
    @Column(name="mapx") private String mapx;
    @Column(name="mapy") private String mapy;
    @Column(name="mlevel") private String mlevel;
    @Column(name="modifiedtime") private String modifiedtime;
    @Column(name="readcount") private String readcount;
    @Column(name="sigungucode") private String sigungucode;
    @Column(name="tel") private String tel;
    @Column(name="title") private String title;
    @Column(name="zipcode") private String zipcode;

    @OneToMany(mappedBy = "place")
    private List<Review> reviews = new ArrayList<>();

    @OneToOne(mappedBy = "place")
    private PlaceDetail placedetail;
    public Place() {};
}