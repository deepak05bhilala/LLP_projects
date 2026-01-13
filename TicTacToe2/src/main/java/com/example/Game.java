package com.example;

import com.example.Board.Board;
import com.example.Enum.GameStatus;
import com.example.GameState.GameState;
import com.example.GameState.impl.InProgressState;
import com.example.Player.Player;
import com.example.WinningStrategy.WinningStrategy;
import com.example.WinningStrategy.impl.DiagonalWinStrategy;
import com.example.WinningStrategy.impl.HorizontalWinStrategy;
import com.example.WinningStrategy.impl.VerticalWinStrategy;
import lombok.Getter;

import java.util.List;

@Getter
public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private List<WinningStrategy> listWinningStrategy;
    private GameState state;
    private Player winner;
    private GameStatus status;

    public Game(Player player1,Player player2, int boardSize){
        this.player1=player1;
        this.player2=player2;
        this.currentPlayer=player1;
        this.board= new Board(boardSize);
        this.listWinningStrategy= List.of(new VerticalWinStrategy(),new HorizontalWinStrategy(), new DiagonalWinStrategy());
        this.state= new InProgressState();
        this.status= GameStatus.IN_PROGRESS;
    }

}
