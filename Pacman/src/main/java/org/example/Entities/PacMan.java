package org.example.Entities;

public class PacMan {

    private static final int extraLifePoints = 10000;

    private int gamePoints;

    private int lives;

    private int ghostMultiplier;

    private int counterForExtraLife = 1;

    public PacMan(int gamePoints, int lives) {
        this.gamePoints = gamePoints;
        this.lives = lives;
        this.ghostMultiplier = 1;
    }

    public int getGamePoints() {
        return gamePoints;
    }

    public void setGamePoints(int gamePoints) {
        this.gamePoints = gamePoints;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getCounterForExtraLife() {
        return counterForExtraLife;
    }

    public void setCounterForExtraLife(int counterForExtraLife) {
        this.counterForExtraLife = counterForExtraLife;
    }

    public void addLive(){
        this.lives ++;
    }

    public void removeLive(){
        this.lives --;
    }

    public int getGhostMultiplier() {
        return ghostMultiplier;
    }

    public void setGhostMultiplier(int ghostMultiplier) {
        this.ghostMultiplier = ghostMultiplier;
    }

    public void incrementGhostMultiplier() {
        this.ghostMultiplier ++;
    }

    public void addPoints(int points){
        if (checkAddLive(points)) {
            addLivesForReachedPoints(gamePoints);
        }
        this.gamePoints += points;
    }

    protected boolean checkAddLive(int points){
        int necessaryPointsForExtraLife = counterForExtraLife * extraLifePoints;
        return this.gamePoints <  necessaryPointsForExtraLife && this.gamePoints + points >= necessaryPointsForExtraLife;
    }
    protected void addLivesForReachedPoints(int points){
        addLive();
        this.counterForExtraLife++;
    }
}
