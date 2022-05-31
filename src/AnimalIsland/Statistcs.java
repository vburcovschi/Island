package AnimalIsland;

import java.util.*;

import static AnimalIsland.AnimalType.*;
import static AnimalIsland.Service.*;
import static AnimalIsland.Start.*;

public  class Statistcs {
    public static Map<AnimalType, Integer> doCalculationsAliveAnimals(Island myIsland){
        Map<AnimalType, Integer> animalCounter = new HashMap<>();
        Set<Animal> animals;
        Cell[][] cells = myIsland.getCells();
        for (int i = 0; i < myIsland.getHeight()-1; i++) {
            for (int j = 0; j < myIsland.getWidth()-1; j++) {
                animals = cells[i][j].getAnimals();
                for (Animal animal: animals) {
                    AnimalType at = AnimalType.valueOf(animal.getAnimalTypeName());
                    int value;
                    if (animalCounter.get(at)==null)
                        value = 1;
                    else
                        value = animalCounter.get(at)+ 1;
                    animalCounter.put(at,value);
                }
            }
        }
        return animalCounter;
    }

/*    public static Map<AnimalType, Integer> doCalculationsAliveAnimals(Island myIsland){
        Map<AnimalType, Integer> animalCounter = new HashMap<>();
        Set<Animal> animals;
        Cell[][] cells = myIsland.getCells();
        for (int i = 0; i < myIsland.getHeight()-1; i++) {
            for (int j = 0; j < myIsland.getWidth()-1; j++) {
                Cell cell = cells[i][j];
                animalCounter.forEach((k,v) -> animalCounter(cell).merge(k,v, Integer::sum));
            }
        }
        return animalCounter;
    }*/

    public static int getWolfAliveCount(Map<AnimalType, Integer> map){
        int i;
        if (map.containsKey(Wolf))
            i = map.get(Wolf);
        else
            i = 0;
        return i;
    }

    public static int getWolfDiedCount(Map<AnimalType, Integer> map){
        int i;
        if (map.containsKey(Wolf))
            i = map.get(Wolf);
        else
            i = 0;
        return i;
    }

    public static int getHorseAliveCount(Map<AnimalType, Integer> map){
        int i;
        if (map.containsKey(Horse))
            i = map.get(Horse);
        else
            i = 0;
        return i;
    }

    public static int getHorseDiedCount(Map<AnimalType, Integer> map){
        int i;
        if (map.containsKey(Horse))
            i = map.get(Horse);
        else
            i = 0;
        return i;
    }

    public static Map<AnimalType, Integer> doCalculationDiedAnimals (Set<Animal> animals){
        Map<AnimalType, Integer> animalCounter = new HashMap<>();
        for (Animal key: animals) {
            AnimalType at = AnimalType.valueOf(key.getClass().getSimpleName());
            if (animalCounter.get(at)==null)
                animalCounter.put(at,1);
            else
                animalCounter.put(at,animalCounter.get(at) + 1);
        }
        return animalCounter;
    }

    public static void showStatisctic(Island myIsland){
        Map<AnimalType, Integer> mapAlive = doCalculationsAliveAnimals(myIsland);
        Map<AnimalType, Integer> mapDied = doCalculationDiedAnimals(died);
        int wolfAliveCount = getWolfAliveCount(mapAlive);
        int wolfDiedCount = getWolfDiedCount(mapDied);
        int horseAliveCount = getHorseAliveCount(mapAlive);
        int horseDiedCount = getHorseDiedCount(mapDied);
        System.out.println();
        System.out.format("Step: %d                  Wolf burn/died: %d/%d  Horse burn/died: %d/%d",iter,wolfAliveCount,wolfDiedCount,horseAliveCount,horseDiedCount);
        System.out.println();
    }
}
