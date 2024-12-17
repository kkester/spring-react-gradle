package io.pivotal.demo.board;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private Board board;

    public Board createBoard() {
        Row row1 = createBlackRow();
        Row row2 = createWhiteRow();
        Row row3 = createBlackRow();
        Row row4 = createWhiteRow();
        Row row5 = createBlackRow();
        board = Board.builder()
                .rows(List.of(row1, row2, row3, row4, row5))
                .build();
        return board;
    }

    private Row createBlackRow() {
        return Row.builder()
                .cells(List.of(
                        Cell.builder().status(CellStatus.BLACK).build(),
                        Cell.builder().status(CellStatus.WHITE).build(),
                        Cell.builder().status(CellStatus.BLACK).build(),
                        Cell.builder().status(CellStatus.WHITE).build(),
                        Cell.builder().status(CellStatus.BLACK).build()
                ))
                .build();
    }

    private Row createWhiteRow() {
        return Row.builder()
                .cells(List.of(
                        Cell.builder().status(CellStatus.WHITE).build(),
                        Cell.builder().status(CellStatus.BLACK).build(),
                        Cell.builder().status(CellStatus.WHITE).build(),
                        Cell.builder().status(CellStatus.BLACK).build(),
                        Cell.builder().status(CellStatus.WHITE).build()
                ))
                .build();
    }

    public Board updateBoard(Integer index) {
        board.getRows().forEach(row -> row.getCells().stream()
                .filter(cell -> cell.getStatus() == CellStatus.CURRENT)
                .forEach(cell -> cell.setStatus(CellStatus.SELECTED))
        );

        int rowIndex = index / 5;
        Row row = board.getRows().get(rowIndex);
        row.getCells().get(index - (rowIndex * 5)).setStatus(CellStatus.CURRENT);

        return board;
    }
}
