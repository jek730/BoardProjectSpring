package org.kje.board.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBoard is a Querydsl query type for Board
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoard extends EntityPathBase<Board> {

    private static final long serialVersionUID = 259733555L;

    public static final QBoard board = new QBoard("board");

    public final org.kje.global.entities.QBaseMemberEntity _super = new org.kje.global.entities.QBaseMemberEntity(this);

    public final BooleanPath active = createBoolean("active");

    public final StringPath bid = createString("bid");

    public final StringPath bName = createString("bName");

    public final StringPath category = createString("category");

    public final EnumPath<org.kje.member.constants.Authority> commentAccessType = createEnum("commentAccessType", org.kje.member.constants.Authority.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> deletedAt = _super.deletedAt;

    public final StringPath gid = createString("gid");

    public final StringPath htmlBottom = createString("htmlBottom");

    public final StringPath htmlTop = createString("htmlTop");

    public final EnumPath<org.kje.member.constants.Authority> listAccessType = createEnum("listAccessType", org.kje.member.constants.Authority.class);

    public final NumberPath<Integer> listOrder = createNumber("listOrder", Integer.class);

    public final StringPath locationAfterWriting = createString("locationAfterWriting");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    public final NumberPath<Integer> pageCountMobile = createNumber("pageCountMobile", Integer.class);

    public final NumberPath<Integer> pageCountPc = createNumber("pageCountPc", Integer.class);

    public final EnumPath<org.kje.member.constants.Authority> replyAccessType = createEnum("replyAccessType", org.kje.member.constants.Authority.class);

    public final NumberPath<Integer> rowsPerPage = createNumber("rowsPerPage", Integer.class);

    public final BooleanPath showListBelowView = createBoolean("showListBelowView");

    public final StringPath skin = createString("skin");

    public final BooleanPath useComment = createBoolean("useComment");

    public final BooleanPath useEditor = createBoolean("useEditor");

    public final BooleanPath useReply = createBoolean("useReply");

    public final BooleanPath useUploadFile = createBoolean("useUploadFile");

    public final BooleanPath useUploadImage = createBoolean("useUploadImage");

    public final EnumPath<org.kje.member.constants.Authority> viewAccessType = createEnum("viewAccessType", org.kje.member.constants.Authority.class);

    public final EnumPath<org.kje.member.constants.Authority> writeAccessType = createEnum("writeAccessType", org.kje.member.constants.Authority.class);

    public QBoard(String variable) {
        super(Board.class, forVariable(variable));
    }

    public QBoard(Path<? extends Board> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBoard(PathMetadata metadata) {
        super(Board.class, metadata);
    }

}

