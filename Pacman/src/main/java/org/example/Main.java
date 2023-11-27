package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> pacManGameSteps = retrieveGameSteps();
        GameManager gameManager = new GameManager(pacManGameSteps);

        printResults(gameManager);
    }

    private static List<String> retrieveGameSteps() {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("beanTech-seq.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return records.get(0);
    }

    private static void printResults(GameManager gameManager){
        System.out.println("Total points: ".concat(String.valueOf(gameManager.getGamesPoints())));
        System.out.println("Total lives: ".concat(String.valueOf(gameManager.getGamesLives())));
    }
}
