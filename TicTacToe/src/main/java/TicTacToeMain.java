package com.example.RishiTraders.TicTacToe;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;

@Profile("tic-tac-toe")
public class TicTacToeMain implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        TicTacToeGame ticTacToeGame =new TicTacToeGame(3);
        System.out.printf("Game winner is %s%n", ticTacToeGame.startGame());

    }
}