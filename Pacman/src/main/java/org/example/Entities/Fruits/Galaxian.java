package org.example.Entities.Fruits;

import org.example.Entities.GameEntity;

public class Galaxian extends GameEntity implements Fruit {

    private final int points = 2000;
    @Override
    public int getDefaultEntityPoints() {
        return points;
    }
}
