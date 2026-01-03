package com.example;

public class HasQuarterState implements State {

    private final GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You already inserted a quarter. You can't insert another one.");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned.");
        gumballMachine.setCurrentState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCranker() {
        System.out.println("You turned the crank...");
        gumballMachine.setCurrentState(gumballMachine.getSoldState());
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed. Turn the crank first.");
    }
}

