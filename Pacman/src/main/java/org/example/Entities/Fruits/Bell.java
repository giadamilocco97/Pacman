package org.example.Entities.Fruits;

import org.example.Entities.GameEntity;

public class Bell extends GameEntity implements Fruit {

    private final int points = 3000;
    @Override
    public int getDefaultEntityPoints() {
        return points;
    }
}
