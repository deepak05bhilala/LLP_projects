package com.example.RishiTraders.TicTacToe;


public class Board {
    private final Integer size;
    private final PlayingPiece[][] board;

    public Board(Integer size){
        this.size=size;
        board= new PlayingPiece[size][size];
    }

    public boolean placePiece(Integer row, Integer col, PlayingPiece playingPiece){
        if(row<0 || row>=size || col<0 || col>size){
            System.out.println("row= " + row + ", col= " + col + " are not valid coordinates");
            return false;
        }
        else if(board[row][col]!=null){
            System.out.println("The coordinate is already occupied");
            return  false;
        }
        else{
            board[row][col]=playingPiece;
            return true;
        }
    }

    public boolean isFull(){
        for(PlayingPiece[] row: board){
            for (PlayingPiece cell : row){
                if(cell==null){
                    return false;
                }
            }
        }
        return true;
    }
}
