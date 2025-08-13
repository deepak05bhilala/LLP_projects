package com.example.RishiTraders.SnakeNLadder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//@Profile("snake-n-ladder")
public class SnakeNLadderMain {


    public static void main(String []args){

        Scanner sc = new Scanner(System.in);

        Board board = new Board(100);


        System.out.println("Number of snakes : ");
        int snake = sc.nextInt();


        for( int i=0; i<snake; i++){

            System.out.println("snake starts : ");
            int snakeStart = sc.nextInt();

            System.out.println("snake ends : ");
            int snakeEnd = sc.nextInt();

            board.snakes.put(snakeStart, snakeEnd);

        }

        System.out.println("Number of ladders : ");
        int ladder = sc.nextInt();

        for(int i=0; i<ladder; i++){

            System.out.println("ladder starts: ");
            int ladderStart = sc.nextInt();

            System.out.println("ladder ends : ");
            int ladderEnd = sc.nextInt();

            board.ladders.put(ladderStart, ladderEnd);
        }


        System.out.println("Number of players : ");
        int playerCount = sc.nextInt();

        List<Player> playerList = new ArrayList<>();
        for(int i=0; i<playerCount; i++){

            System.out.println("player name : ");
            String player = sc.next();

           Player playerObj = Player.builder().Name(player).position(0).build();
           playerList.add(playerObj);

        }

        Dice dice = new Dice(6);

        SnakeAndLadder snakeAndLadder = new SnakeAndLadder(board, dice, playerList);
        snakeAndLadder.startGame();


    }
}
