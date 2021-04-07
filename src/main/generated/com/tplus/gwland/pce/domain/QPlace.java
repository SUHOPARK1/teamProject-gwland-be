package com.tplus.gwland.pce.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPlace is a Querydsl query type for Place
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPlace extends EntityPathBase<Place> {

    private static final long serialVersionUID = 1915677695L;

    public static final QPlace place = new QPlace("place");

    public final StringPath addr1 = createString("addr1");

    public final StringPath addr2 = createString("addr2");

    public final StringPath areacode = createString("areacode");

    public final StringPath cat1 = createString("cat1");

    public final StringPath cat2 = createString("cat2");

    public final StringPath cat3 = createString("cat3");

    public final NumberPath<Long> contentid = createNumber("contentid", Long.class);

    public final StringPath contenttypeid = createString("contenttypeid");

    public final StringPath createdtime = createString("createdtime");

    public final StringPath firstimage = createString("firstimage");

    public final StringPath firstimage2 = createString("firstimage2");

    public final StringPath mapx = createString("mapx");

    public final StringPath mapy = createString("mapy");

    public final StringPath mlevel = createString("mlevel");

    public final StringPath modifiedtime = createString("modifiedtime");

    public final StringPath overveiw = createString("overveiw");

    public final StringPath readcount = createString("readcount");

    public final ListPath<com.tplus.gwland.rev.domain.Review, com.tplus.gwland.rev.domain.QReview> reviews = this.<com.tplus.gwland.rev.domain.Review, com.tplus.gwland.rev.domain.QReview>createList("reviews", com.tplus.gwland.rev.domain.Review.class, com.tplus.gwland.rev.domain.QReview.class, PathInits.DIRECT2);

    public final StringPath sigungucode = createString("sigungucode");

    public final StringPath tel = createString("tel");

    public final StringPath title = createString("title");

    public final StringPath zipcode = createString("zipcode");

    public QPlace(String variable) {
        super(Place.class, forVariable(variable));
    }

    public QPlace(Path<? extends Place> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPlace(PathMetadata metadata) {
        super(Place.class, metadata);
    }

}

