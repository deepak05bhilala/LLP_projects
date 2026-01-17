package com.example;

import com.example.Board.Board;
import com.example.Player.Player;

import java.util.Deque;
import java.util.Random;

public class Game {
    private Deque<Player> playerList;
    private Board board;
    private Random random = new Random();


    public Game(Deque<Player> playerList,Board board){
        this.playerList=playerList;
        this.board=board;
    }

    public boolean makeTurn(){
        if(playerList.isEmpty()){
            System.out.println("No Players left in the game.Game Ends!!");
            return false;
        }
        Player player = playerList.getFirst();
        String playerName= player.getName();
        Integer playerCurrentPosition=player.getCurrentPosition();
        Integer diceValue= rollDice();
        System.out.printf("You rolled %d %n",diceValue);
        Integer playerNewPosition = board.updatePosition(playerCurrentPosition,diceValue);
        player.setCurrentPosition(playerNewPosition);
        System.out.printf("Player %s current position was %d and new position is %d%n",
                playerName, playerCurrentPosition, playerNewPosition);
        if (playerNewPosition==board.getSize()* board.getSize()){
            System.out.printf("Player %s won, other players continue",playerName);
            playerList.pollFirst();
            System.out.printf("Player %s turn %n",playerList.getFirst().getName());
        }
        else if(diceValue==6){
            System.out.printf("Bingo %s,As You rolled 6 and got an extra turn %n",playerName);
        }else{
            playerList.addLast(playerList.pollFirst());
            System.out.printf("Player %s turn %n",playerList.getFirst().getName());
        }
        return true;
    }
    public Integer rollDice(){
        return random.nextInt(6) + 1;
    }
}
