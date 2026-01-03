package com.example;

public class NoQuarterState implements State {

    private final GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Quarter inserted. You can now turn the crank.");
        gumballMachine.setCurrentState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("No quarter to eject. You haven't inserted a quarter yet.");
    }

    @Override
    public void turnCranker() {
        System.out.println("You turned the crank, but there's no quarter. Insert a quarter first.");
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed. Please insert a quarter.");
    }
}

