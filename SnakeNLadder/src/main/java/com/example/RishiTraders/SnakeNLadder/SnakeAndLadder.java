package com.example.RishiTraders.SnakeNLadder;

import lombok.Data;

import java.util.List;

@Data
public class SnakeAndLadder {


    Board board;
    Dice dice;
    List<Player> playerList;

    public SnakeAndLadder(Board board, Dice dice, List<Player> playerList) {
        this.board = board;
        this.dice = dice;
        this.playerList = playerList;
    }

    public void startGame() {

        while(true){

           if( playerList.size()  == 1){
               System.out.println(playerList.get(0).getName() + " Loss the game");
               System.out.println("Game Over !!!");
               break;

           }
            for(Player p : playerList){


                int newPos = p.getPosition() + dice.roll();

                if(newPos == board.getSize()){
                    System.out.println(p.getName() + " WON");
                    playerList.remove(p);
                    continue;
                }
                if(newPos > board.getSize()){
                    continue;
                }
                else if(board.snakes.containsKey(newPos)){
                    newPos = board.snakes.get(newPos);
                }else if(board.ladders.containsKey(newPos)){
                    newPos = board.ladders.get(newPos);
                }
                System.out.println(p.getName() + " position " + newPos);
                p.setPosition(newPos);
            }

        }
    }
}
