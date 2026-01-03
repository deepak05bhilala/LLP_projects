package com.example;

public class SoldState implements State {

    private final GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Please wait, we're already giving you a gumball.");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry, you already turned the crank. You can't eject the quarter.");
    }

    @Override
    public void turnCranker() {
        System.out.println("Turning twice doesn't get you another gumball!");
    }

    @Override
    public void dispense() {
        System.out.println("A gumball comes rolling out...");
        gumballMachine.releaseBall();

        if (gumballMachine.getCount() > 0) {
            System.out.println("Ready for the next customer.");
            gumballMachine.setCurrentState(gumballMachine.getNoQuarterState());
        } else {
            System.out.println("Oops, out of gumballs for next customer!");
            gumballMachine.setCurrentState(gumballMachine.getSoldOutState());
        }
    }
}

