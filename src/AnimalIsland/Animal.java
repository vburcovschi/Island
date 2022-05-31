package AnimalIsland;

import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;


public abstract class Animal {
    private Gender gender;
    private int weight;
    private int speed;
    private int foodNorm;
    private boolean saturation;
    private int saturationLevel;
    private int x;
    private int y;
    private static int max_children;
    static Map<AnimalType, Integer> eaten;

    public Animal(Gender gender, int weight, int speed, int foodNorm, int x, int y, int max_children) {
        this.gender = gender;
        this.weight = weight;
        this.speed = speed;
        this.foodNorm = foodNorm;
        this.saturation = false;
        this.saturationLevel = 0;
        this.x = x;
        this.y = y;
        this.max_children = max_children;
    }

    public Animal(Gender gender, int x, int y) {
        this.gender = gender;
        this.x = x;
        this.y = y;
        this.saturation = false;
    }

    public void eat(int foodMass) {
        this.saturationLevel = this.saturationLevel + foodMass;
        this.saturation = (this.saturationLevel>=this.foodNorm);
    }

    public Set<Animal> giveBirth(Animal animal) {
        if (this.gender==Gender.MALE)
            return null;
        else {
            AnimalType animalType = AnimalType.valueOf(animal.getClass().getSimpleName());
            Random rnd = new Random();
            Set<Animal> childrens = new HashSet<>();
            int child_count = rnd.nextInt(animal.getMax_children());
            for (int i = 0; i < child_count-1; i++) {
                boolean gender;
                gender = rnd.nextBoolean();
                Gender sex = (gender) ? Gender.MALE : Gender.FEMALE;
                    switch (animalType) {
                        case Horse:
                            childrens.add(new Herbivore.Horse(sex, this.x, this.y));
                            break;
                        case Wolf:
                            childrens.add(new Predator.Wolf(sex, this.x, this.y));
                            break;
                        case Boa:
                            childrens.add(new Predator.Boa(sex, this.x, this.y));
                            break;
                        case Bear:
                            childrens.add(new Predator.Bear(sex, this.x, this.y));
                            break;
                        case Eagle  :
                            childrens.add(new Predator.Eagle(sex, this.x, this.y));
                            break;
                        case Fox  :
                            childrens.add(new Predator.Fox(sex, this.x, this.y));
                            break;
                        case Deer:
                            childrens.add(new Herbivore.Deer(sex, this.x, this.y));
                            break;
                        case Rabbit:
                            childrens.add(new Herbivore.Rabbit(sex, this.x, this.y));
                            break;
                        case Mouse:
                            childrens.add(new Herbivore.Rabbit(sex, this.x, this.y));
                            break;
                        case Goat:
                            childrens.add(new Herbivore.Goat(sex, this.x, this.y));
                            break;
                    }
            }
            return childrens;
        }
    }

    public void moveTo(Direction direction) {
        switch (direction){
            case BACKWARD: this.setX(this.getX()-this.getSpeed());
                break;
            case FORWARD: this.setX(this.getX()+this.getSpeed()) ;
            break;
            case UP: this.setY(this.getY()-this.getSpeed()) ;
            break;
            case DOWN: this.setY(this.getY()+this.getSpeed()) ;
            break;
        }
    }

    public boolean isSaturation() {
        return saturation;
    }

    public void setSaturation(boolean saturation) {
        this.saturation = saturation;
    }

    public int getSaturationLevel() {
        return saturationLevel;
    }

    public void setSaturationLevel(int saturationLevel) {
        this.saturationLevel = saturationLevel;
    }


    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getFoodNorm() {
        return foodNorm;
    }

    public void setFoodNorm(int foodNorm) {
        this.foodNorm = foodNorm;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public static int getMax_children() {
        return max_children;
    }

    public void setMax_children(int max_children) {
        this.max_children = max_children;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+"," + this.getGender() + ",[" + this.getX() +","+this.getY()+"] ";
    }

    public String getAnimalTypeName() {
        return this.getClass().getSimpleName();
    }

    public static void setEaten(Map<AnimalType, Integer> eaten) {
        Animal.eaten = eaten;
    }

    public static Map<AnimalType, Integer> getEaten() {
        return eaten;
    }

    public int findPray(Set<Animal> animals, AnimalType[] orderToEatAnimals) {
        for (int i = 0; i < orderToEatAnimals.length - 1; i++) {
            for (Animal animal : animals) {
                if (orderToEatAnimals[i].equals(animal.getAnimalTypeName()))
                    return animal.getWeight();
            }
        }
        return 0;
    }

}
