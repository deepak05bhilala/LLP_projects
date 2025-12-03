package com.example;

import com.example.Piece.PieceType;
import com.example.Piece.PlayingPiece;
import com.example.Piece.PlayingPieceO;
import com.example.Piece.PlayingPieceX;

public class Board {
    Integer size;
    PlayingPiece[][] board;

    Board(Integer size){
        this.size=size;
        board = new PlayingPiece[size][size];
        for (int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                board[i][j]=new PlayingPiece(PieceType.EMPTY);
            }
        }
    }

    public void printBoard(){
        System.out.print("-------\n");
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print("|");
                if (board[i][j].getPieceType() == PieceType.EMPTY){
                    System.out.print(" ");
                }
                else if(board[i][j].getPieceType() == PieceType.X){
                    System.out.print("X");
                }
                else if (board[i][j].getPieceType() == PieceType.O) {
                    System.out.print("O");
                }
            }
            System.out.print("|\n");
            System.out.print("-------\n");
        }

    }

    public boolean placePiece(int r, int c, PlayingPiece playingPiece){
        if(board[r][c].getPieceType() == PieceType.EMPTY){
            board[r][c]=playingPiece;
            return true;
        }
        return false;
    }

    public boolean checkWinner(int r, int c, PlayingPiece playingPiece){
        PieceType type = playingPiece.getPieceType();

        boolean checkRow= true;
        boolean checkCol= true;
        boolean checkDig1= true;
        boolean checkDig2= true;

        //Checking Row
        for (int j = 0; j < size; j++) {
            if (board[r][j].getPieceType()==PieceType.EMPTY || board[r][j].getPieceType() != type) {
                checkRow = false;
                break;
            }
        }
        // Checking Columns
        for (int i = 0; i < size; i++) {
            if (board[i][c].getPieceType()==PieceType.EMPTY || board[i][c].getPieceType() != type) {
                checkCol = false;
                break;
            }
        }

        // Check Main Diagonal (only if r == c)
        if (r == c) {
            for (int i = 0; i < size; i++) {
                if (board[i][i].getPieceType()==PieceType.EMPTY || board[i][i].getPieceType() != type) {
                    checkDig1 = false;
                    break;
                }
            }
        } else {
            checkDig1 = false;
        }

        // Check Anti-Diagonal (only if r + c == size - 1)
        if (r + c == size - 1) {
            for (int i = 0; i < size; i++) {
                if (board[i][size - 1 - i].getPieceType()==PieceType.EMPTY || board[i][size - 1 - i].getPieceType() != type) {
                    checkDig2 = false;
                    break;
                }
            }
        } else {
            checkDig2 = false;
        }

        return checkRow | checkCol | checkDig1 | checkDig2;
    }

    public int getEmptyCellCount(){
        int count=0;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j].getPieceType() == PieceType.EMPTY){
                    count++;
                }
            }
        }
        return  count;
    }
}
