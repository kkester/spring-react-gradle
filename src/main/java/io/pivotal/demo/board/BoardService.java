package io.pivotal.demo.board;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class BoardService {

    private Board board;

    @Value("${application.board.row-length}")
    private Integer rowLength;

    @Value("${application.board.column-length}")
    private Integer columnLength;

    public Board createBoard() {

        List<Row> rows = IntStream.range(0, rowLength)
                .mapToObj(this::createRow)
                .toList();
        board = Board.builder()
                .rows(rows)
                .build();
        return board;
    }

    private Row createRow(int rowIndex) {
        CellStatus currentStatus = ( (rowIndex & 1) == 0 ) ? CellStatus.WHITE : CellStatus.BLACK;

        List<Cell> cells = new ArrayList<>();
        Cell firstCell = Cell.builder().status(currentStatus).build();
        cells.add(firstCell);
        for (int columnIndex = 1; columnIndex < columnLength; columnIndex++) {
            CellStatus nextStatus = CellStatus.BLACK.equals(currentStatus) ? CellStatus.WHITE : CellStatus.BLACK;
            Cell nextCell = Cell.builder().status(nextStatus).build();
            cells.add(nextCell);
            currentStatus = nextStatus;
        }

        return Row.builder().cells(cells).build();
    }

    public Board updateBoard(Integer index) {
        board.getRows().forEach(row -> row.getCells().stream()
                .filter(cell -> cell.getStatus() == CellStatus.CURRENT)
                .forEach(cell -> cell.setStatus(CellStatus.SELECTED))
        );

        int cellSize = board.getRowCellSize();
        int rowIndex = index / cellSize;
        Row row = board.getRows().get(rowIndex);
        row.getCells().get(index - (rowIndex * cellSize)).setStatus(CellStatus.CURRENT);

        return board;
    }
}
