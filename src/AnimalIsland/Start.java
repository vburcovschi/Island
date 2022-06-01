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
    public static boolean exitCondition;
    public static Island myIsland = new Island(ISLAND_WIDTH, ISLAND_HEIGHT, new Cell[ISLAND_HEIGHT][ISLAND_WIDTH]);
    public static ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
    public static void main(String[] args) {
        populateIsland();
        iter = 0;
        showStatisctic();
        iter++;
        scheduledExecutorService.scheduleAtFixedRate(new Service(),INITIAL_DELAY,CYCLE_PERIOD,TimeUnit.MILLISECONDS);
    }






}
