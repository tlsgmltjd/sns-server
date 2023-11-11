package com.example.hellochat.domain.Board.controller;

import com.example.hellochat.domain.Board.dto.request.CreateBoardRequest;
import com.example.hellochat.domain.Board.dto.response.BoardsResponse;
import com.example.hellochat.domain.Board.service.BoardService;
import com.example.hellochat.global.security.UserDetailsImpl;
import com.example.hellochat.global.util.MsgResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<MsgResponseDto> boardPost(@RequestBody CreateBoardRequest request, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        boardService.postBoard(request, userDetails.getUser());
        return ResponseEntity.ok(new MsgResponseDto("게시글 등록이 완료되었습니다.", HttpStatus.OK.value()));
    }

    @GetMapping
    public ResponseEntity<List<BoardsResponse>> boardsFind() {
        return ResponseEntity.ok(boardService.findBoad());
    }
}
