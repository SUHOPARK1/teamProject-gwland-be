package com.tplus.gwland.cmm.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tplus.gwland.rev.domain.ReviewDto;

import lombok.RequiredArgsConstructor;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component @RequiredArgsConstructor
public class Crawler extends Proxy {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	// private final Vector<ReviewDto> artBag;
	public Vector<ReviewDto> crawling(String url2) {
		String url = "https://www.tripadvisor.co.kr/Restaurant_Review-g317129-d9104708-Reviews-Dancheon_Noodles-Sokcho_Gangwon_do.html";
		ArrayList<ReviewDto> revBox = new ArrayList<>();
		try {
			Document rawData = Jsoup.connect(url).timeout(10 * 1000).get();
			
			Elements titles = rawData.select("span[class=ratingDate]");
			Elements cliid = rawData.select("div[class=info_text pointer_cursor]");
			Elements contents = rawData.select("p[class=partial_entry]");
			Elements starRate = rawData.select("span[class=r2Cf69qf]");
			ReviewDto review = null;
			
			logger.info("리뷰갯수: " + titles.size());
			logger.info("총 평균 별점: " + starRate.text());
			for (int i = 0; i < titles.size(); i++) {
				review = new ReviewDto();
				
				review.setReviewId(cliid.get(i).text());
				review.setReviewTitle(titles.get(i).text());
				review.setReviewContent(contents.get(i).text());
				logger.info("리뷰 번호 " + (i+1) + "번: " + review.toString());
				revBox.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		Crawler c = new Crawler();
		c.crawling("");
	}
}