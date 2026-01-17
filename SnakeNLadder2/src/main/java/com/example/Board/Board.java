package com.example.Board;

import com.example.Cell.Cell;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Board {
    private Integer size;
    Map<Integer, Cell> cellMap = new HashMap<>();

    public Board(Integer size){
        this.size=size;
        for(int i=1;i<size*size+1;i++){
            cellMap.put(i,new Cell(i));
        }
    }
    public void setSnake(Integer startCell, Integer endCell){
        // Condition to check invalid Position
        Cell cell = cellMap.get(startCell);
        cell.setJump(endCell-startCell);
    }
    public void setLadder(Integer startCell, Integer endCell){
        Cell cell = cellMap.get(startCell);
        cell.setJump(endCell-startCell);
    }

    public Integer updatePosition(Integer playerCurrentPosition, Integer diceValue){
        if(playerCurrentPosition+diceValue>=size*size){
            return playerCurrentPosition;
        }
        Cell cell = cellMap.get(playerCurrentPosition+diceValue);
        Integer jump= cell.getJump();
        if(jump<0){
            System.out.println("Player encountered Snake");
        }else if(jump>1){
            System.out.println("Player encountered Ladder");
        }else{
            System.out.println("Player encountered No Ladder No Snake");
        }
        return playerCurrentPosition+diceValue+jump;
    }
}
