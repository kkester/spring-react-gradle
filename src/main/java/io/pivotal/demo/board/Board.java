package io.pivotal.demo.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board {

    private List<Row> rows;

    public int getRowCellSize() {
        return rows == null || rows.isEmpty() ? 0 : rows.getFirst().getCells().size();
    }
}
