package org.example.Entities.Fruits;

import org.example.Entities.GameEntity;

public class Apple extends GameEntity implements Fruit {

    private final int points = 700;

    @Override
    public int getDefaultEntityPoints() {
        return points;
    }
}
