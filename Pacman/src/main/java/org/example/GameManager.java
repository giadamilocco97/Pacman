package org.example;

import org.example.Entities.Dot;
import org.example.Entities.Fruits.*;
import org.example.Entities.GameEntity;
import org.example.Entities.Ghost.Ghost;
import org.example.Entities.Ghost.InvincibleGhost;
import org.example.Entities.Ghost.VulnerableGhost;
import org.example.Entities.PacMan;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class GameManager {
    private static final int startingPoints = 5000;
    private static final int startingLives = 3;

    private PacMan pacMan;

    public GameManager(List<String> pacManGameSteps) {
        pacMan = new PacMan(startingPoints, startingLives);

        parseGameSteps(pacManGameSteps, pacMan);
    }

    protected void parseGameSteps(List<String> gameSteps, PacMan pacMan){

        Map<String, String> gameEntitiesMappings = retrievesGamesEntitiesMappings();


        for (String entityName : gameSteps) {
            GameEntity gameEntity = null;
            try {
                Class<?> entity = Class.forName(gameEntitiesMappings.get(entityName));
                gameEntity = (GameEntity) entity.getDeclaredConstructor().newInstance();
            }  catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                System.out.println(e);
            } catch (InvocationTargetException | NoSuchMethodException | SecurityException e) {
                throw new RuntimeException(e);
            }

            printActualPointsAndLives();

            System.out.println(entityName);

            if (gameEntity instanceof Dot || gameEntity instanceof Fruit) {
                pacMan.addPoints(gameEntity.getGamePoints());
                continue;
            }
            if (gameEntity instanceof Ghost) {
                manageGhost((Ghost) gameEntity, pacMan);
            }

            hasNoLives();
        }
    }

    private void printActualPointsAndLives() {
        System.out.println("Actual points: ".concat(String.valueOf(getGamesPoints())));
        System.out.println("Actual lives: ".concat(String.valueOf(getGamesLives())));
    }

    private void hasNoLives() {
        if (this.getGamesLives() == 0){
            printActualPointsAndLives();
            System.out.println("GAME OVER");
            System.exit(1);
        }
    }

    protected void manageGhost(Ghost ghost, PacMan pacMan){
        if (ghost instanceof InvincibleGhost) {
            pacMan.removeLive();

            pacMan.setGhostMultiplier(1);
        }
        if (ghost instanceof VulnerableGhost) {
            int gamePoints = ghost.getGamePoints() * pacMan.getGhostMultiplier();
            pacMan.addPoints(gamePoints);
            pacMan.incrementGhostMultiplier();
        }

        // throw exception for non managed entity
    }

    public int getGamesPoints(){
        return pacMan.getGamePoints();
    }

    public int getGamesLives(){
        return pacMan.getLives();
    }

    private static Map<String, String> retrievesGamesEntitiesMappings() {
        Map<String, String> gameEntities = new TreeMap<>();
        gameEntities.put("Dot", Dot.class.getName());
        gameEntities.put("Apple", Apple.class.getName());
        gameEntities.put("Bell", Bell.class.getName());
        gameEntities.put("Cherry", Cherry.class.getName());
        gameEntities.put("Galaxian", Galaxian.class.getName());
        gameEntities.put("Key", Key.class.getName());
        gameEntities.put("Melon", Melon.class.getName());
        gameEntities.put("Orange", Orange.class.getName());
        gameEntities.put("Strawberry", Strawberry.class.getName());
        gameEntities.put("InvincibleGhost", InvincibleGhost.class.getName());
        gameEntities.put("VulnerableGhost", VulnerableGhost.class.getName());
        return gameEntities;
    }
}
