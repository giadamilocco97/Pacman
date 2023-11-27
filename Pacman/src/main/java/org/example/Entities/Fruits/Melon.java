package org.example.Entities.Fruits;

import org.example.Entities.GameEntity;

public class Melon extends GameEntity implements Fruit {

    private final int points = 1000;
    @Override
    public int getDefaultEntityPoints() {
        return points;
    }
}
