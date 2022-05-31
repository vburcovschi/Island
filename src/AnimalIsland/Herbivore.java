package AnimalIsland;

import java.util.Set;

import static AnimalIsland.Properties.*;

public abstract class Herbivore extends Animal{
    public Herbivore(Gender gender, int weight, int speed, int foodNorm, int x, int y, int max_children) {
        super(gender, weight, speed, foodNorm, x, y, max_children);
    }

    public Herbivore(Gender gender, int x, int y) {
        super(gender, x, y);
    }

    public static class Horse extends Herbivore{
        static int weight = HORSE_WEIGHT;
        static int speed = HORSE_SPEED;
        static int food_norm = HORSE_FOOD_NORM;
        static int max_children = HORSE_MAX_CHILDREN;
        public Horse(Gender gender, int x, int y) {
            super(gender, x, y);
            this.setWeight(weight);
            this.setSpeed(speed);
            this.setFoodNorm(food_norm);
            this.setMax_children(max_children);
        }

        public Horse(Gender gender, int weight, int speed, int foodNorm, int x, int y, int max_children) {
            super(gender, weight, speed, foodNorm, x, y, max_children);
        }

        @Override
        public void findPray(Set<Animal> animals, AnimalType[] orderToEatAnimals) {
            for (int i = 0; i < orderToEatAnimals.length-1; i++) {
                for (Animal animal: animals) {
                    if (orderToEatAnimals[i].equals(animal.getAnimalTypeName())){
                        animal.setSaturationLevel();
                    }
                    }
                }
            }
            return null;
    }
}
