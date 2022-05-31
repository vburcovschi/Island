package AnimalIsland;

import java.util.Map;

import static AnimalIsland.AnimalType.*;
import static AnimalIsland.Properties.*;

public abstract class Herbivore extends Animal {

    public Herbivore(Gender gender, int x, int y) {
        super(gender, x, y);
    }

    public static class Horse extends Herbivore {
        static int weight = HORSE_WEIGHT;
        static int speed = HORSE_SPEED;
        static int food_norm = HORSE_FOOD_NORM;
        static int max_children = HORSE_MAX_CHILDREN;
        static Map<AnimalType, Integer> eaten = Map.of(Wolf,0,Boa,0, Fox,0, Bear,0, Eagle,0, Deer,0, Rabbit,0, Mouse,0, Goat,0,Sheep,0);

        public Horse(Gender gender, int x, int y) {
            super(gender, x, y);
            this.setWeight(weight);
            this.setSpeed(speed);
            this.setFoodNorm(food_norm);
            this.setEaten(eaten);
            this.setMax_children(max_children);
        }
    }

    public static class Deer extends Herbivore {
        static int weight = DEER_WEIGHT;
        static int speed = DEER_SPEED;
        static int food_norm = DEER_FOOD_NORM;
        static int max_children = DEER_MAX_CHILDREN;
        static Map<AnimalType, Integer> eaten = Map.of(Wolf,0, Boa,0, Fox,0, Bear,0, Eagle,0, Horse,0, Rabbit,90, Mouse,0, Goat,0, Sheep,0);

        public Deer(Gender gender, int x, int y) {
            super(gender, x, y);
            this.setWeight(weight);
            this.setSpeed(speed);
            this.setFoodNorm(food_norm);
            this.setEaten(eaten);
            this.setMax_children(max_children);
        }
    }

    public static class Rabbit extends Herbivore {
        static int weight = RABBIT_WEIGHT;
        static int speed = RABBIT_SPEED;
        static int food_norm = RABBIT_FOOD_NORM;
        static int max_children = RABBIT_MAX_CHILDREN;
        static Map<AnimalType, Integer> eaten = Map.of(Wolf,0, Boa,0, Fox,0, Bear,0, Eagle,0, Horse,0, Rabbit,0, Mouse,0, Goat,0, Sheep,0);

        public Rabbit(Gender gender, int x, int y) {
            super(gender, x, y);
            this.setWeight(weight);
            this.setSpeed(speed);
            this.setFoodNorm(food_norm);
            this.setEaten(eaten);
            this.setMax_children(max_children);
        }
    }

    public static class Mouse extends Herbivore {
        static int weight = MOUSE_WEIGHT;
        static int speed = MOUSE_SPEED;
        static int food_norm = MOUSE_FOOD_NORM;
        static int max_children = MOUSE_MAX_CHILDREN;
        static Map<AnimalType, Integer> eaten = Map.of(Wolf,0, Boa,0, Fox,0, Bear,0, Eagle,0, Horse,0, Rabbit,0, Mouse,0, Goat,0, Sheep,0);

        public Mouse(Gender gender, int x, int y) {
            super(gender, x, y);
            this.setWeight(weight);
            this.setSpeed(speed);
            this.setFoodNorm(food_norm);
            this.setEaten(eaten);
            this.setMax_children(max_children);
        }
    }

    public static class Goat extends Herbivore {
        static int weight = GOAT_WEIGHT;
        static int speed = GOAT_SPEED;
        static int food_norm = GOAT_FOOD_NORM;
        static int max_children = GOAT_MAX_CHILDREN;
        static Map<AnimalType, Integer> eaten = Map.of(Wolf,0, Boa,0, Fox,0, Bear,0, Eagle,0, Horse,0, Rabbit,0, Mouse,0, Goat,0, Sheep,0);

        public Goat(Gender gender, int x, int y) {
            super(gender, x, y);
            this.setWeight(weight);
            this.setSpeed(speed);
            this.setFoodNorm(food_norm);
            this.setEaten(eaten);
            this.setMax_children(max_children);
        }
    }
}
