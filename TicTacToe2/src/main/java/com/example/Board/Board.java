package com.example.Board;

import com.example.Cell.Cell;
import com.example.Enum.Symbol;
import com.example.Exception.InvalidMoveException;

public class Board {
    private final int size;
    private int movesCount;
    private final Cell[][] board;

    public Board(int size) {
        this.size = size;
        this.board =new Cell[size][size];
        movesCount=0;
        initialiseBoard();
    }
    private void initialiseBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                board[i][j]= new Cell(Symbol.Empty);
            }
        }
    }

    public boolean placeSymbol(Symbol symbol, int row, int col){
        if (row < 0 || row >= size || col < 0 || col >= size) {
            throw new InvalidMoveException("Invalid position: out of bounds.");
        }
        if (board[row][col].getSymbol() != Symbol.Empty) {
            throw new InvalidMoveException("Invalid position: cell is already occupied.");
        }
        board[row][col].setSymbol(symbol);
        movesCount++;
        return true;
    }

    public void printBoard(){
        System.out.println("------------");
        for(int i=0 ;i<size ; i++){
            System.out.println("|");
            for(int j=0;j<size;j++){
                System.out.println(board[i][j]);
            }
            System.out.println("------------");
        }
    }

    public boolean isFull(){
        return size==movesCount;
    }

    public Cell getCell(int row, int col) {
        if (row < 0 || row >= size || col < 0 || col >= size) {
            return null;
        }
        return board[row][col];
    }
}
