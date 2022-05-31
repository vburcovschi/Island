package AnimalIsland;


import java.util.*;

import static AnimalIsland.Island.*;
import static AnimalIsland.Properties.*;
import static AnimalIsland.Service.*;
import static AnimalIsland.Statistcs.*;


public class Start {
    public static int iter;
    public static void main(String[] args) throws InterruptedException {
        Island myIsland = new Island(ISLAND_WIDTH, ISLAND_HEIGHT, new Cell[ISLAND_HEIGHT][ISLAND_WIDTH]);
/*        Herbivore.Horse horse = new Horse(1, Sex.MALE);
        System.out.println(horse.toString());
        Predator.Wolf wolf = new Wolf(1,Sex.FEMALE);
        System.out.println(wolf.toString());
        System.out.println("Wolf speed is: "+wolf.getSpeed());
        System.out.println((Animal)wolf instanceof Predator);*/
//        System.out.println("\uD83D\uDC3A");
        catchAnimal();
/*        populateIsland(myIsland);
        System.out.println(myIsland);
        iter = 1;
        while (checkAnimalsAlive(myIsland)){
            showStatisctic(myIsland);
            moveAnimalsBulk(myIsland);
            System.out.println(myIsland);
            reproducingAnimals(myIsland);
            iter++;
            Thread.sleep(500);
        }
        showStatisctic(myIsland);
        System.out.println(myIsland);
        System.out.println("Game Over!");*/
    }






}
