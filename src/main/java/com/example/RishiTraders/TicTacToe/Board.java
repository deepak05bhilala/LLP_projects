package com.example.RishiTraders.TicTacToe;





import org.springframework.data.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Board {
    Integer size;
    public PlayingPiece[][] board;

    public Board(Integer size){
        this.size=size;
        board= new PlayingPiece[size][size];
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                PlayingPiece p = board[i][j];
                System.out.print((p == null ? " " : p.pieceType.name()) + " ");
            }
            System.out.println();
        }
    }

    public List<Pair<Integer,Integer>> getFreeCells(){
        List<Pair<Integer,Integer>>  freeCells= new ArrayList<>();
        for(Integer i=0; i<size ;i++) {
            System.out.println("\n");
            for(Integer j=0;j<size;j++){
                if(board[i][j]==null){
                    Pair<Integer,Integer> freeRowColumn = Pair.of(i, j);
                    freeCells.add(freeRowColumn);
                }
            }
        }
        return freeCells;
    }
}
