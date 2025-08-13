package com.example.RishiTraders.SnakeNLadder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Player {
    private String Name;
    private Integer position;
}
