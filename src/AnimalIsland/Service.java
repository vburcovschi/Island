package AnimalIsland;

import java.util.*;

import static AnimalIsland.AnimalType.*;
import static AnimalIsland.Direction.*;
import static AnimalIsland.Properties.*;
import static AnimalIsland.Start.exitCondition;
import static AnimalIsland.Start.myIsland;

public class Service implements Runnable{
    public static Set<Animal> died = new HashSet<>();

    public static boolean checkAnimalsAlive() {
        Boolean result = false;
        Cell[][] cells = myIsland.getCells();
        for (int i = 0; i < myIsland.getHeight(); i++) {
            for (int j = 0; j < myIsland.getWidth(); j++) {
                result = result | (cells[i][j].getAnimals().size() != 0);
            }
        }
        return result;
    }

    public static Direction getMoveDirection() {
        Random rnd = new Random();
        int direction = rnd.nextInt(3);
        switch (direction) {
            case 0:
                return BACKWARD;
            case 1:
                return FORWARD;
            case 2:
                return UP;
            case 3:
                return DOWN;
            default:
                return BACKWARD;
        }
    }

    public static void moveAnimalsBulk(){
        Set<Animal> animals;
        Cell[][] cells = myIsland.getCells();
        for (int i = 0; i < myIsland.getHeight(); i++) {
            for (int j = 0; j < myIsland.getWidth(); j++) {
                animals = cells[i][j].getAnimals();
                if (animals.size() != 0) {
                    for (Animal animal : animals) {
                        animal.moveTo(getMoveDirection());
                    }
                }
            }
        }
        /*Adjustment of received coordinates */
        for (int i = 0; i < myIsland.getHeight(); i++) {
            for (int j = 0; j < myIsland.getWidth(); j++) {
                animals = cells[i][j].getAnimals();
                Iterator<Animal> itr = animals.iterator();
                while (itr.hasNext()) {
                    Animal animal = itr.next();
                    int width = myIsland.getWidth();
                    int height = myIsland.getHeight();
                    if (animal.getY() < 0 | animal.getY() >= width | animal.getX() < 0 | animal.getX() >= height) {
                        died.add(animal); // kill objects out of island area
                        itr.remove();
                    } else {
                        int newX = animal.getX();
                        int newY = animal.getY();
                        cells[newX][newY].getAnimals().add(animal);
                        itr.remove();
                        CheckExtraPopulationByTypeByCell(animalCounter(cells[i][j]), cells[i][j]);
                    }
                }
            }
        }
    }

    public static AnimalType calcMaxTypeAnimal(Cell cell) {
        Map<AnimalType, Integer> animalCounter = new HashMap<>();
        Iterator<Animal> itr = cell.getAnimals().iterator();
        for (Iterator<Animal> it = itr; it.hasNext(); ) {
            Animal animal = it.next();
            AnimalType at = AnimalType.valueOf(animal.getClass().getSimpleName());
            int value;
            if (animalCounter.get(at) == null)
                value = 1;
            else
                value = animalCounter.get(at) + 1;
            animalCounter.put(at, value);
        }
        int max = 0;
        AnimalType tmp = X;
        for (AnimalType key : animalCounter.keySet()) {
            if (max < animalCounter.get(key)) {
                max = animalCounter.get(key);
                tmp = key;
            }
        } // 🐃, 🐻, 🐎, 🦌, 🐗, 🐑, 🐐, 🐺, 🐍, 🦊, 🦅, 🐇, 🦆, 🐁, 🐛.
        return tmp;
    }

    public static String animalTypeToGraphic(AnimalType animalType) {
        switch (animalType) {
            case Wolf:
                return "\uD83D\uDC3A";
            case Boa:
                return "\uD83D\uDC0D";
            case Horse:
                return "\uD83D\uDC0E";
            case Fox:
                return "\uD83E\uDD8A";
            case Bear:
                return "\uD83D\uDC3B";
            case Eagle:
                return "\uD83E\uDD85";
            case Deer:
                return "\uD83E\uDD8C";
            case Rabbit:
                return "\uD83D\uDC07";
            case Mouse:
                return "\uD83D\uDC01";
            case Goat:
                return "\uD83D\uDC10";
            default:
                return "\u2639";
        }
    }

    public static void reproducingAnimals() {
        Set<Animal> animals;
        Cell[][] cells = myIsland.getCells();
        for (int i = 0; i < myIsland.getHeight(); i++) {
            for (int j = 0; j < myIsland.getWidth(); j++) {
                animals = cells[i][j].getAnimals();
                Set<Animal> animalscopy = new HashSet<>(animals);
                for (Animal animal : animals) {
                    Set<Animal> childrens = animal.giveBirth(animal);
                    if (childrens != null) {
                        animalscopy.addAll(childrens);
                        CheckExtraPopulationByTypeByCell(animalCounter(cells[i][j]), cells[i][j]);
                    }
                }
            }
        }
    }

    public static void CheckExtraPopulationByTypeByCell(Map<AnimalType, Integer> map, Cell cell) {
        for (AnimalType key : map.keySet()) {
            switch (key) {
                case Horse:
                    cleanExcessAnimal(key, map.get(key), MAX_HORSES_ON_CELL, cell);
                    break;
                case Wolf: {
                    cleanExcessAnimal(key, map.get(key), MAX_WOLF_ON_CELL, cell);
                    break;
                }
                case Boa: {
                    cleanExcessAnimal(key, map.get(key), MAX_BOA_ON_CELL, cell);
                    break;
                }
                case Fox: {
                    cleanExcessAnimal(key, map.get(key), MAX_FOX_ON_CELL, cell);
                    break;
                }
                case Bear: {
                    cleanExcessAnimal(key, map.get(key), MAX_BEAR_ON_CELL, cell);
                    break;
                }
                case Eagle: {
                    cleanExcessAnimal(key, map.get(key), MAX_EAGLE_ON_CELL, cell);
                    break;
                }
                case Deer: {
                    cleanExcessAnimal(key, map.get(key), MAX_DEER_ON_CELL, cell);
                    break;
                }
                case X:
                    break;
            }
        }
    }

    public static void cleanExcessAnimal(AnimalType animalType, int currentCountOfAnimalType, int maxAnimalsTypeOnCell, Cell cell) {
        if (currentCountOfAnimalType > maxAnimalsTypeOnCell) {
            int i = 1;
            int diference = currentCountOfAnimalType - maxAnimalsTypeOnCell;
            Set<Animal> copyAnimal = cell.getAnimals();
            for (Animal list : cell.getAnimals()) {
                if (list.getAnimalTypeName().equals(animalType)) {
                    copyAnimal.remove(list);
                    i++;
                    if (i > diference)
                        break;
                }
            }
        }
    }

    public static Map<AnimalType, Integer> animalCounter(Cell cell) {
        Map<AnimalType, Integer> animalCounter = new HashMap<>();
        for (Animal animal : cell.getAnimals()) {
            AnimalType at = AnimalType.valueOf(animal.getAnimalTypeName());
            if (animalCounter.get(at) == null)
                animalCounter.put(at, 1);
            else
                animalCounter.put(at, animalCounter.get(at) + 1);
        }
        return animalCounter;
    }

    public static void eatAnimalBulk() {
        Set<Animal> animals;
        Set<Animal> filteredAnimals;
        Set<Animal> eatenAnimals;
        Cell[][] cells = myIsland.getCells();
        for (int i = 0; i < myIsland.getHeight(); i++) {
            for (int j = 0; j < myIsland.getWidth(); j++) {
                animals = cells[i][j].getAnimals();
                eatenAnimals = new HashSet<>(animals);
                filteredAnimals = new HashSet<>(animals);
                for (Animal animal : animals) {
                    if (!animal.isSaturation()){
                        int eatMass = animal.findPray(eatenAnimals,orderToEatAnimals(animal));
                        if (eatMass!=0){
                            animal.eat(eatMass);
                            eatenAnimals.remove(animal);}
                        else filteredAnimals.remove(animal);
                    }
                }
            }
        }
    }

    public static AnimalType[] orderToEatAnimals(Animal animal) {
        if (animal.eaten.size()!=0) {
            Map<AnimalType, Integer> sorted_Eaten = animal.eaten.entrySet().stream()
                    .filter(x -> x.getValue() > 0)
                    .sorted(Map.Entry.comparingByValue())
                    .collect(LinkedHashMap::new, (m, c) -> m.put(c.getKey(), c.getValue()), LinkedHashMap::putAll);
            AnimalType[] eatenAnimals = new AnimalType[sorted_Eaten.size()];
            int i = 0;
            for (Map.Entry<AnimalType, Integer> keySet : sorted_Eaten.entrySet()) {
                eatenAnimals[i] = keySet.getKey();
                i++;
            }
            return eatenAnimals;
        }else
            return new AnimalType[0];
    }

    @Override
    public void run() {
        moveAnimalsBulk();
        exitCondition = checkAnimalsAlive();
        reproducingAnimals();
        exitCondition = checkAnimalsAlive();
        eatAnimalBulk();
        exitCondition = checkAnimalsAlive();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
