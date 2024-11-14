package umc.spring.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMissionComplete is a Querydsl query type for MissionComplete
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMissionComplete extends EntityPathBase<MissionComplete> {

    private static final long serialVersionUID = 404652953L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMissionComplete missionComplete = new QMissionComplete("missionComplete");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final umc.spring.domain.QMember member;

    public final umc.spring.domain.QMission mission;

    public final EnumPath<umc.spring.domain.enums.MissionStatus> status = createEnum("status", umc.spring.domain.enums.MissionStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMissionComplete(String variable) {
        this(MissionComplete.class, forVariable(variable), INITS);
    }

    public QMissionComplete(Path<? extends MissionComplete> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMissionComplete(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMissionComplete(PathMetadata metadata, PathInits inits) {
        this(MissionComplete.class, metadata, inits);
    }

    public QMissionComplete(Class<? extends MissionComplete> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new umc.spring.domain.QMember(forProperty("member")) : null;
        this.mission = inits.isInitialized("mission") ? new umc.spring.domain.QMission(forProperty("mission"), inits.get("mission")) : null;
    }

}

