package com.tplus.gwland.rcm.domain;

import javax.persistence.*;

import com.tplus.gwland.crs.domain.Course;
import com.tplus.gwland.rev.domain.Review;
import com.tplus.gwland.svy.domain.Survey;

@Entity @Table(name ="recommends")
public class Recom {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id @Column(name="rcm_num")
    private long rcmNum;

    @ManyToOne
    @JoinColumn(name="crs_num")
    private Course course;
    @ManyToOne
    @JoinColumn(name="svy_num")
    private Survey survey;
    @ManyToOne
    @JoinColumn(name="rev_num")
    private Review review;
}
