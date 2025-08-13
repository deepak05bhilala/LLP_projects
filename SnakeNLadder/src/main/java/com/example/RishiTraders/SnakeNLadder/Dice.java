package com.example.RishiTraders.SnakeNLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    private Integer numberOfDice=6;

    public Dice(Integer numberOfDice){
        this.numberOfDice=numberOfDice;
    }

    public Integer roll(){
        Integer totalRollValue=0;
        for(int i=0;i<numberOfDice;i++){
            //TODO: Remember this function
            totalRollValue+= ThreadLocalRandom.current().nextInt(1, 7);
        }
        return totalRollValue;
    }
}
