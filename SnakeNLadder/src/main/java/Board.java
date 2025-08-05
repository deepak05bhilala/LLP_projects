package com.example.RishiTraders.SnakeNLadder;

public class Board {
    private Integer size;
    private Cell[][] cells;

    public Board(Integer size){
        this.size=size;
        cells = new Cell[size][size];
    }

}
