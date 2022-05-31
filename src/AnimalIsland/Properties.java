package AnimalIsland;

import java.util.Map;

import static AnimalIsland.AnimalType.*;

public class Properties {
    protected static final int ISLAND_WIDTH = 85;
    protected static final int ISLAND_HEIGHT = 15;
    protected static final int WOLF_WEIGHT = 50;
    protected static final int WOLF_SPEED = 3;
    protected static final int WOLF_FOOD_NORM = 8;
    protected static final int WOLF_MAX_CHILDREN = 7;
    protected static final int MAX_WOLF_ON_CELL = 30;

    protected static final int HORSE_WEIGHT = 400;
    protected static final int HORSE_SPEED = 4;
    protected static final int HORSE_FOOD_NORM = 60;
    protected static final int MAX_HORSES_ON_CELL = 20;
    protected static final int HORSE_MAX_CHILDREN = 2;

 //   Wolf,0, Boa,0, Fox,0, Bear,0, Eagle,0, Horse,10, Deer,15, Rabbit,60, Mouse,80, Goat,60, Sheep,70


    protected static final Map<AnimalType, Integer> HORSE_EATEN = Map.of(Wolf,0, Boa,0, Fox,0, Bear,0, Eagle,0, Deer,0, Rabbit,0, Mouse,0, Goat,0, Sheep,0);



}
