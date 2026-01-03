package com.example;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GumballMachine {
    private Integer count;
    private State noQuarterState;
    private State hasQuarterState;
    private State soldState;
    private State soldOutState;
    private State currentState;

    public GumballMachine(Integer numberOfGumball) {
        noQuarterState =new NoQuarterState(this);
        hasQuarterState= new HasQuarterState(this);
        soldState = new SoldState(this);
        soldOutState= new SoldOutState(this);
        count=numberOfGumball;
        if(numberOfGumball>0){
            currentState = noQuarterState;
        }

    }
    public void insertQuarter() {
        currentState.insertQuarter();
    }
    public void ejectQuarter() {
        currentState.ejectQuarter();
    }
    public void turnCranker() {
        currentState.turnCranker();
        currentState.dispense();
    }

    void releaseBall() {
        System.out.println(" A gumball comes rolling out the slot...");
        if (count != 0) {
            count = count - 1;
        }
    }

}
