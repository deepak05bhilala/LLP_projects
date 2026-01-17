package com.example.GameObserver;

import com.example.Game;

import java.util.ArrayList;
import java.util.List;

public abstract class GameSubject {
    private final List<GameObserver> gameObserverList =new ArrayList<>();

    public void addObserver(GameObserver gameObserver){
        gameObserverList.add(gameObserver);
    }
    public void removeObserver(GameObserver gameObserver){
        gameObserverList.remove(gameObserver);
    }
    public void notifyObserver(){
        for(GameObserver gameObserver : gameObserverList){
            gameObserver.update((Game) this);
        }
    }

}
