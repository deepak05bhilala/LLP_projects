package com.example.RishiTraders.TicTacToe;

import org.springframework.data.util.Pair;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TicTacToeGame {

    Deque<Player> players;
    Board board;
    public TicTacToeGame(Integer size){
        initialiseGame(size);
    }

    private void initialiseGame(Integer size){
        players = new LinkedList<>();
        PlayingPiece pieceX = new PlayingPieceX();
        PlayingPiece pieceO = new PlayingPieceO();
        Player player1 = new Player("Siddharth",pieceX);
        Player player2 = new Player("Rahul",pieceO);
        board = new Board(size);
    }

    public String startGame(){
        boolean noWinner=true;
        while(noWinner){

            Player playerTurn = players.removeFirst();

            board.printBoard();
            // Optimise this function
            List<Pair<Integer,Integer>> freeSpaces =board.getFreeCells();
            if(freeSpaces.isEmpty()){
                noWinner=false;
                continue;
            }


        }

        return "";
    }
}
