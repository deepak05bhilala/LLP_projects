package com.example.RishiTraders.SnakeNLadder;

import lombok.Data;

@Data
public class Cell {
    private Integer number;
    private boolean isSnake;
    private boolean isLadder;
    private Integer jump;
}
