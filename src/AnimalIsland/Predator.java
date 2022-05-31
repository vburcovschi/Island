package AnimalIsland;

import java.util.Map;
import java.util.Random;
import java.util.Set;

import static AnimalIsland.AnimalType.*;
import static AnimalIsland.AnimalType.Sheep;
import static AnimalIsland.Properties.*;
import static AnimalIsland.Service.animalCounter;

public abstract class Predator extends Animal{

    public Predator(Gender gender, int weight, int speed, int foodNorm, int x, int y, int max_children) {
        super(gender, weight, speed, foodNorm, x, y, max_children);
    }

    public Predator(Gender gender, int x, int y) {
        super( gender, x, y);
    }

    public static class Wolf extends Predator{
        static int weight = WOLF_WEIGHT;
        static int speed = WOLF_SPEED;
        static int food_norm = WOLF_FOOD_NORM;
        static int max_children = WOLF_MAX_CHILDREN;
        static Map<AnimalType, Integer> eaten = Map.of(Boa,0, Fox,0, Bear,0, Eagle,0, Horse,10, Deer,15, Rabbit,60, Mouse,80, Goat,60,Sheep,70);

        public Wolf(Gender gender, int weight, int speed, int foodNorm, int x, int y, int max_children) {
            super(gender, weight, speed, foodNorm, x, y, max_children);
        }

        public Wolf(Gender gender, int x, int y) {
            super(gender, x, y);
            this.setWeight(weight);
            this.setSpeed(speed);
            this.setFoodNorm(food_norm);
            this.setMax_children(max_children);
        }

        @Override
        public void findPray(Set<Animal> animals, AnimalType[] orderToEatAnimals) {

        }
    }
}

