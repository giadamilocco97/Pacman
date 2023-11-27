package org.example.Entities;

public abstract class GameEntity {

    private int points;

    public GameEntity() {
        this.points = getDefaultEntityPoints();
    }

    public int getGamePoints() {
        return points;
    }

    public void setGamePoints(int gamePoints) {
        this.points = gamePoints;
    }

    public abstract int getDefaultEntityPoints();
}
