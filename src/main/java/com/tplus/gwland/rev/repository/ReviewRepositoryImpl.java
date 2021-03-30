package com.tplus.gwland.rev.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import static com.tplus.gwland.rev.domain.QReview.review;
import static com.tplus.gwland.pce.domain.QPlace.place;
import com.tplus.gwland.rev.domain.Review;
import com.tplus.gwland.rev.domain.ReviewDto;

@Repository
public class ReviewRepositoryImpl extends QuerydslRepositorySupport implements ReviewCustomRepository{
	private final EntityManager em;
	private final JPAQueryFactory qf;
	public ReviewRepositoryImpl(EntityManager em, JPAQueryFactory qf) {
		super(Review.class);
		this.em = em;
		this.qf = qf;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Review> findByRevName(String revName) {
		return em.createQuery("select b from review b where b.rev_name like :revName")
				 .setParameter("revName", revName)
				 .getResultList();
	}
	public List<ReviewDto> findList() {
		List<Tuple> ls = qf.select(review.revNum, review.revStar, review.revContent,
								   review.revDate, review.revName).from(review).fetch();
		List<ReviewDto> reviewList = new ArrayList<>();
		for(int i=0;i<ls.size();i++) {
			ReviewDto r = new ReviewDto();
			r.setRevContent(ls.get(i).get(review.revContent));
			r.setRevNum(ls.get(i).get(review.revNum));
			r.setRevStar(ls.get(i).get(review.revStar));
			r.setRevDate(ls.get(i).get(review.revDate));
			r.setRevName(ls.get(i).get(review.revName));
			reviewList.add(r);
		}
		return reviewList;
	}
}



