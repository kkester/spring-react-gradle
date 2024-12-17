package io.pivotal.demo.board;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public Board getBoard() {
        return boardService.createBoard();
    }

    @PostMapping
    public Board updateBoard(@RequestParam(name = "square") Integer index) {
        return boardService.updateBoard(index);
    }
}
