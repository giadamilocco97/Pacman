package org.example.Entities.Fruits;

import org.example.Entities.GameEntity;

public class Strawberry extends GameEntity implements Fruit {

    private final int points = 300;

    @Override
    public int getDefaultEntityPoints() {
        return points;
    }
}
