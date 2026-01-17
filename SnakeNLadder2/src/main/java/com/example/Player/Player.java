package com.example.Player;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private String name;
    private Integer currentPosition;

    public Player(String name){
        this.name=name;
        currentPosition=0;
    }
}
