package org.example.Entities.Fruits;

import org.example.Entities.GameEntity;

public class Cherry extends GameEntity implements Fruit {

   private final int points = 100;
   @Override
   public int getDefaultEntityPoints() {
      return points;
   }
}
