package com.tplus.gwland.rev.domain;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.tplus.gwland.pce.domain.Place;
import com.tplus.gwland.rcm.domain.Recom;
import com.tplus.gwland.usr.domian.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Entity @Getter @Table(name = "review")
public class Review {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="rev_num")private long revNum;
	@Column(name="rev_name")private String revName;
	@Column(name="rev_star")private String revStar;
	@Column(name="rev_content")private String revContent;
	@Column(name="rev_date")private String revDate;
	
	@OneToMany(mappedBy= "review")
	private List<Recom> recom = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="num")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="contentid")
	private Place place;

	@Builder
	
	public Review(long revNum, String revName, String revStar, String revContent, 
			      String revDate, List<Recom> recom, User user, Place place) {
		super();
		this.revNum = revNum;
		this.revName = revName;
		this.revStar = revStar;
		this.revContent = revContent;
		this.revDate = revDate;
		this.recom = recom;
		this.user = user;
		this.place = place;
	}
 }
	
	






