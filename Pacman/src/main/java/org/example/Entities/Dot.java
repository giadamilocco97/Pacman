package org.example.Entities;

public class Dot  extends GameEntity {

    private final int points = 10;

    public Dot() {
    }

    @Override
    public int getDefaultEntityPoints() {
        return points;
    }
}
