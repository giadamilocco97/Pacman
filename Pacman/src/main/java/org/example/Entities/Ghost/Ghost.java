package org.example.Entities.Ghost;

import org.example.Entities.GameEntity;

public class Ghost extends GameEntity {

    private static final int points = 200;

    @Override
    public int getDefaultEntityPoints() {
        return points;
    }
}
