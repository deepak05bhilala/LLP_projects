package com.example.Cell;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Cell {
    private Integer position;
    private Integer jump;
    public Cell(Integer position){
        this.position=position;
        this.jump=0;
    }
}
