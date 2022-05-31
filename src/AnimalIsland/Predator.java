package AnimalIsland;

import java.util.Map;

import static AnimalIsland.AnimalType.*;
import static AnimalIsland.Properties.*;

public abstract class Predator extends Animal {

    public Predator(Gender gender, int x, int y) {
        super(gender, x, y);
    }

    public static class Wolf extends Predator {
        static int weight = WOLF_WEIGHT;
        static int speed = WOLF_SPEED;
        static int food_norm = WOLF_FOOD_NORM;
        static int max_children = WOLF_MAX_CHILDREN;
        static Map<AnimalType, Integer> eaten = Map.of(Boa, 0, Fox, 0, Bear, 0, Eagle, 0, Horse, 10, Deer, 15, Rabbit, 60, Mouse, 80, Goat, 60, Sheep, 70);

        public Wolf(Gender gender, int x, int y) {
            super(gender, x, y);
            this.setWeight(weight);
            this.setSpeed(speed);
            this.setFoodNorm(food_norm);
            this.setMax_children(max_children);
            this.setEaten(eaten);
        }

    }

    public static class Boa extends Predator {
        static int weight = BOA_WEIGHT;
        static int speed = BOA_SPEED;
        static int food_norm = BOA_FOOD_NORM;
        static int max_children = BOA_MAX_CHILDREN;
        static Map<AnimalType, Integer> eaten = Map.of(Fox, 15, Bear, 0, Eagle, 0, Horse, 0, Deer, 0, Rabbit, 20, Mouse, 40, Goat, 0, Sheep, 0);


        public Boa(Gender gender, int x, int y) {
            super(gender, x, y);
            this.setWeight(weight);
            this.setSpeed(speed);
            this.setFoodNorm(food_norm);
            this.setMax_children(max_children);
            this.setEaten(eaten);
        }
    }

    public static class Fox extends Predator {
        static int weight = FOX_WEIGHT;
        static int speed = FOX_SPEED;
        static int food_norm = FOX_FOOD_NORM;
        static int max_children = FOX_MAX_CHILDREN;
        static Map<AnimalType, Integer> eaten = Map.of(Wolf, 0, Boa, 0, Bear, 0, Eagle, 0, Horse, 10, Deer, 15, Rabbit, 90, Mouse, 90, Goat, 0, Sheep, 0);

        public Fox(Gender gender, int x, int y) {
            super(gender, x, y);
            this.setWeight(weight);
            this.setSpeed(speed);
            this.setFoodNorm(food_norm);
            this.setMax_children(max_children);
            this.setEaten(eaten);
        }
    }

    public static class Bear extends Predator {
        static int weight = BEAR_WEIGHT;
        static int speed = BEAR_SPEED;
        static int food_norm = BEAR_FOOD_NORM;
        static int max_children = BEAR_MAX_CHILDREN;
        static Map<AnimalType, Integer> eaten = Map.of(Wolf, 0, Boa, 80, Fox, 0, Eagle, 0, Horse, 40, Deer, 80, Rabbit, 80, Mouse, 90, Goat, 70, Sheep, 70);

        public Bear(Gender gender, int x, int y) {
            super(gender, x, y);
            this.setWeight(weight);
            this.setSpeed(speed);
            this.setFoodNorm(food_norm);
            this.setMax_children(max_children);
            this.setEaten(eaten);
        }
    }

    public static class Eagle extends Predator{
        static int weight = EAGLE_WEIGHT;
        static int speed = EAGLE_SPEED;
        static int food_norm = EAGLE_FOOD_NORM;
        static int max_children = EAGLE_MAX_CHILDREN;
        static Map<AnimalType, Integer> eaten = Map.of(Wolf,0, Boa,0, Fox,10, Bear,0, Horse,0, Deer,0, Rabbit,90, Mouse,90, Goat,0, Sheep,0);

        public Eagle(Gender gender, int x, int y) {
            super(gender, x, y);
            this.setWeight(weight);
            this.setSpeed(speed);
            this.setFoodNorm(food_norm);
            this.setMax_children(max_children);
            this.setEaten(eaten);
        }
    }
}


