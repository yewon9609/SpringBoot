package com.example.board.controller;

import com.example.board.domain.vo.ReplyVO;
import com.example.board.service.BoardService;
import com.example.board.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/*
 * REST(Representational State Transfer)
 *
 *   하나의 URI는 하나의 고유한 리소스를 대표하도록 설계된다.
 *   예)/board/123 : 게시물 중 123번
 * */

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/replies/*")
public class ReplyController {
    private final ReplyService replyService;

    //    댓글 등록
//    브라우저에서 JSON타입으로 데이터를 전송하고 서버에서는 댓글의 처리 결과에 따라 문자열로 결과를 리턴한다.
//    consumes : 전달받은 데이터의 타입
//    produces : 콜백함수로 결과를 전달할 때의 타입
//    @RequestBody : 전달받은 데이터를 알맞는 매개변수로 주입할 때 사용
//    ResponseEntity : 서버의 상태코드, 응답 메세지 등을 담을 수 있는 타입
    @PostMapping(value = "/new", consumes = "application/json", produces = "text/plain; charset=utf-8")
    public ResponseEntity<String> create(@RequestBody ReplyVO replyVO) throws UnsupportedEncodingException {
        log.info("replyVO : " + replyVO);
        return replyService.register(replyVO) ? new ResponseEntity<>(new String("댓글 등록 성공".getBytes(), "UTF-8"), HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}





















