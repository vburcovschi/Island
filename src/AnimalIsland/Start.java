package AnimalIsland;


import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.TimeUnit;

import static AnimalIsland.Island.*;
import static AnimalIsland.Properties.*;
import static AnimalIsland.Service.*;
import static AnimalIsland.Statistics.*;


public class Start {
    public static int iter;
    public static Island myIsland = new Island(ISLAND_WIDTH, ISLAND_HEIGHT, new Cell[ISLAND_HEIGHT][ISLAND_WIDTH]);
    public static void main(String[] args) throws InterruptedException {
        populateIsland();
        iter = 0;
        showStatisctic();
        System.out.println(myIsland);
        iter++;
        while (checkAnimalsAlive()){
            moveAnimalsBulk();
            reproducingAnimals();
            eatAnimalBulk();
            showStatisctic();
            System.out.println(myIsland);
            iter++;
            Thread.sleep(500);
        }
        System.out.println("Game Over!");
    }






}
