package com.example.RishiTraders.SnakeNLadder;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Board {
    private Integer size;

    Map<Integer, Integer> snakes = new HashMap<>();
    Map<Integer, Integer> ladders = new HashMap<>();

    public Board(int size){
        this.size=size;
    }

}
