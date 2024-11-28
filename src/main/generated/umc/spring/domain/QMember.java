package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 1366956614L;

    public static final QMember member = new QMember("member1");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final ListPath<Ask, QAsk> ask = this.<Ask, QAsk>createList("ask", Ask.class, QAsk.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<umc.spring.domain.enums.Gender> gender = createEnum("gender", umc.spring.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DatePath<java.time.LocalDate> inactiveDate = createDate("inactiveDate", java.time.LocalDate.class);

    public final ListPath<umc.spring.domain.mapping.MemberPrefer, umc.spring.domain.mapping.QMemberPrefer> memberPrefer = this.<umc.spring.domain.mapping.MemberPrefer, umc.spring.domain.mapping.QMemberPrefer>createList("memberPrefer", umc.spring.domain.mapping.MemberPrefer.class, umc.spring.domain.mapping.QMemberPrefer.class, PathInits.DIRECT2);

    public final ListPath<umc.spring.domain.mapping.MissionComplete, umc.spring.domain.mapping.QMissionComplete> missionComplete = this.<umc.spring.domain.mapping.MissionComplete, umc.spring.domain.mapping.QMissionComplete>createList("missionComplete", umc.spring.domain.mapping.MissionComplete.class, umc.spring.domain.mapping.QMissionComplete.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final NumberPath<Integer> phone = createNumber("phone", Integer.class);

    public final ListPath<Review, QReview> review = this.<Review, QReview>createList("review", Review.class, QReview.class, PathInits.DIRECT2);

    public final StringPath specAddress = createString("specAddress");

    public final EnumPath<umc.spring.domain.enums.MemberStatus> status = createEnum("status", umc.spring.domain.enums.MemberStatus.class);

    public final NumberPath<Integer> totalPoint = createNumber("totalPoint", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

