package org.example.Entities.Fruits;

import org.example.Entities.GameEntity;

public class Orange extends GameEntity implements Fruit {

    private final int points = 500;
    @Override
    public int getDefaultEntityPoints() {
        return points;
    }
}
