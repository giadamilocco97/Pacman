package org.example.Entities.Fruits;

import org.example.Entities.GameEntity;

public class Key extends GameEntity implements Fruit {

    private final int points = 5000;
    @Override
    public int getDefaultEntityPoints() {
        return points;
    }
}
