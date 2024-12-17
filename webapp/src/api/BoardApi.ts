export enum CellStatus {
  WHITE,BLACK,SELECTED,CURRENT
}

export type Cell = {
  status: CellStatus;
}

export type Row = {
  cells: Cell[];
}

export type Board = {
  rows: Row[];
}

export const getBoard = async (): Promise<Board> => {
  const data = await fetch("/api/board", {
    method: "GET"
  });
  return await data.json();
};

export const updateBoard = async (index: number): Promise<Board> => {
  const data = await fetch(`/api/board?square=${index}`, {
    method: "POST"
  });
  return await data.json();
};