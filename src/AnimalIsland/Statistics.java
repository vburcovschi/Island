package AnimalIsland;

import java.util.*;

import static AnimalIsland.AnimalType.*;
import static AnimalIsland.Service.*;
import static AnimalIsland.Start.*;

public  class Statistics{
    public static Map<AnimalType, Integer> doCalculationsAliveAnimals(){
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

    public static int getAnimalAliveCount(AnimalType animalType, Map<AnimalType, Integer> map){
        int i;
        if (map.containsKey(animalType))
            i = map.get(animalType);
        else
            i = 0;
        return i;
    }

    public static int getAnimalDiedCount(AnimalType animalType, Map<AnimalType, Integer> map){
        int i;
        if (map.containsKey(animalType))
            i = map.get(animalType);
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

    public static void showStatisctic(){
        Map<AnimalType, Integer> mapAlive = doCalculationsAliveAnimals();
        Map<AnimalType, Integer> mapDied = doCalculationDiedAnimals(died);
        int wolfAliveCount = getAnimalAliveCount(Wolf, mapAlive);
        int wolfDiedCount = getAnimalDiedCount(Wolf, mapDied);
        int boaAliveCount = getAnimalAliveCount(Boa, mapAlive);
        int boaDiedCount = getAnimalDiedCount(Boa, mapDied);
        int eagleAliveCount = getAnimalAliveCount(Eagle, mapAlive);
        int eagleDiedCount = getAnimalDiedCount(Eagle, mapDied);
        int foxAliveCount = getAnimalAliveCount(Fox, mapAlive);
        int foxDiedCount = getAnimalDiedCount(Fox, mapDied);
        int bearAliveCount = getAnimalAliveCount(Bear, mapAlive);
        int bearDiedCount = getAnimalDiedCount(Bear, mapDied);
        int horseAliveCount = getAnimalAliveCount(Horse, mapAlive);
        int horseDiedCount = getAnimalDiedCount(Horse, mapDied);
        int deerAliveCount = getAnimalAliveCount(Deer, mapAlive);
        int deerDiedCount = getAnimalDiedCount(Deer, mapDied);
        int rabbitAliveCount = getAnimalAliveCount(Rabbit, mapAlive);
        int rabbitDiedCount = getAnimalDiedCount(Rabbit, mapDied);
        int mouseAliveCount = getAnimalAliveCount(Mouse, mapAlive);
        int mouseDiedCount = getAnimalDiedCount(Mouse, mapDied);
        int goatAliveCount = getAnimalAliveCount(Goat, mapAlive);
        int goatDiedCount = getAnimalDiedCount(Goat, mapDied);

        System.out.println();
        System.out.format("Step: %d     Wolf burn/died: %d/%d  Boa burn/died: %d/%d  Eagle burn/died: %d/%d  Fox burn/died: %d/%d  Bear burn/died: %d/%d %n",iter,wolfAliveCount,wolfDiedCount,boaAliveCount,boaDiedCount,eagleAliveCount,eagleDiedCount,foxAliveCount,foxDiedCount,bearAliveCount,bearDiedCount);
        System.out.format("Horse burn/died: %d/%d  Deer burn/died: %d/%d  Rabbit burn/died: %d/%d  Mouse burn/died: %d/%d  Goat burn/died: %d/%d %n",horseAliveCount,horseDiedCount,deerAliveCount,deerDiedCount,rabbitAliveCount,rabbitDiedCount,mouseAliveCount,mouseDiedCount,goatAliveCount,goatDiedCount);
        System.out.println(myIsland);
    }

}
