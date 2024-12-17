import React, {useEffect, useState} from 'react';
import '../css/Board.css';
import {Board, CellStatus, getBoard, updateBoard} from "../api/BoardApi";

const get = (s: CellStatus): string => {
    return "Main-board-cell-" + s;
}

export const BoardDisplay = () => {

    const [board, setBoard] = useState<Board>();

    useEffect(() => {
        getBoard()
            .then(response => setBoard(response))
            .catch(error => alert(error));
    }, [])

    let i: number = 0;

    const handleOnClick = (index: number) => {
        return () => {
            console.log(index);
            updateBoard(index)
                .then(response => setBoard(response))
                .catch(error => alert(error));
        }
    }

    return (
        <div id="board">
            <h1>My Board</h1>
            <div className="Main-board">
                {board && board.rows.map(row =>
                    <div className="Main-board-row">
                        {row.cells.map(c => <div className={get(c.status)} onClick={handleOnClick(i++)}/>)}
                    </div>
                )}
            </div>
        </div>
    )
}