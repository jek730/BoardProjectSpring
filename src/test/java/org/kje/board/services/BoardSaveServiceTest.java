package org.kje.board.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kje.board.controllers.RequestBoard;
import org.kje.board.entities.Board;
import org.kje.board.entities.BoardData;
import org.kje.board.repositories.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class BoardSaveServiceTest {

    @Autowired
    private BoardSaveService saveService;

    @Autowired
    private BoardRepository boardRepository;

    private Board board;

    @BeforeEach
    void init() {
        board = new Board();
        board.setBid("freetalk");
        board.setBName("자유게시판");
        /*
         board = Board.builder()
                .bid("freetalk")
                .bName("자유게시판")
                 .gid(UUID.randomUUID().toString())
                 .listAccessType(Authority.ALL)
                 .writeAccessType(Authority.ALL)
                 .commentAccessType(Authority.ALL)
                 .viewAccessType(Authority.ALL)
                 .replyAccessType(Authority.ALL)
                 .locationAfterWriting("list")
                .build();
            */
        boardRepository.saveAndFlush(board);
    }

    @Test
    void saveTest() {
        RequestBoard form = new RequestBoard();
        form.setBid(board.getBid());
        form.setCategory("분류1");
        form.setPoster("작성자");
        form.setSubject("제목");
        form.setContent("내용");
        form.setGuestPw("1234ab");

        BoardData data = saveService.save(form);
        System.out.println(data);

        form.setMode("update");
        form.setSeq(data.getSeq());

        BoardData data2 = saveService.save(form);
        System.out.println(data2);
    }
}