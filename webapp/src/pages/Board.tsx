import React, {useEffect, useState} from 'react';
import '../css/Board.css';

function getRandomInt(max : number) {
  return Math.floor(Math.random() * max);
}

const get = (i : Number) : string => {
  const value = getRandomInt(2);
  return value === 1 ? "Main-board-cell" : "Main-board-cell-selected";
}

export const Board = () => {

  const [timeRemaining, setTimeRemaining] = useState(30);

  useEffect(() => {
    const intervalId = setInterval(() => {
      setTimeRemaining((prevTime) => {
        if (prevTime <= 0) {
          clearInterval(intervalId);
          return 0;
        } else {
          return prevTime - 1;
        }
      });
    }, 1000); // Update every 1 second

    return () => clearInterval(intervalId); // Cleanup on unmount
  }, []);

  return (
    <div id="board">
      <h1>My Board</h1>
      <div className="Main-board">
        <div className="Main-board-row">
          <div className={get(1)} />
          <div className={get(2)} />
          <div className={get(3)} />
          <div className={get(4)} />
          <div className={get(5)} />
        </div>
        <div className="Main-board-row">
          <div className={get(6)} />
          <div className={get(7)} />
          <div className={get(8)} />
          <div className={get(9)} />
          <div className={get(10)} />
        </div>
        <div className="Main-board-row">
          <div className={get(11)} />
          <div className={get(12)} />
          <div className={get(13)} />
          <div className={get(14)} />
          <div className={get(15)} />
        </div>
        <div className="Main-board-row">
          <div className={get(16)} />
          <div className={get(17)} />
          <div className={get(18)} />
          <div className={get(19)} />
          <div className={get(20)} />
        </div>
        <div className="Main-board-row">
          <div className={get(21)} />
          <div className={get(22)} />
          <div className={get(23)} />
          <div className={get(24)} />
          <div className={get(25)} />
        </div>
      </div>
    </div>
  )
}