package com.tplus.gwland.dtl.repository;

import java.util.List;

import static com.tplus.gwland.pce.domain.QPlace.*;
import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tplus.gwland.dtl.domain.PlaceDetail;

@Repository
public class PlaceDetailRepositoryImpl extends QuerydslRepositorySupport implements IPlaceDetailRepository{

    //private final JPAQueryFactory qf;
    private EntityManager em;
    public PlaceDetailRepositoryImpl(EntityManager em) {
        super(PlaceDetail.class);
        //this.qf = qf;
        this.em = em;
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<PlaceDetail> findByContentid(String contentid) {
        return em.createNamedQuery("PlaceDetail.findByContentid").setParameter("contentid", contentid).getResultList();
    }

}
