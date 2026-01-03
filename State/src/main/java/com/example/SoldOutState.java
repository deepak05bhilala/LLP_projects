package com.example;

public class SoldOutState implements State {

    private final GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert a quarter. The machine is sold out.");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You can't eject a quarter. No quarter was inserted.");
    }

    @Override
    public void turnCranker() {
        System.out.println("You turned the crank, but there are no gumballs.");
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed. The machine is sold out.");
    }
}

