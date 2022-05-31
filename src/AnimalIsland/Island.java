package AnimalIsland;

import java.util.*;

import static AnimalIsland.AnimalType.*;
import static AnimalIsland.Properties.*;
import static AnimalIsland.Service.*;
import static AnimalIsland.Start.*;

public class Island {
    private int width;
    private int height;
    private Cell[][] cells;

    public Island(int width, int height, Cell[][] cells) {
        this.width = width;
        this.height = height;
        this.cells = cells;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public static void populateIsland() {
        int width = myIsland.getWidth();
        int height = myIsland.getHeight();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Cell cell = new Cell(new HashSet<>());
                myIsland.cells[i][j] = cell;
                populateAnimalsOnCell(cell, i, j);
            }
        }
    }

    private static void populateAnimalsOnCell(Cell cell, int x, int y) {
        generateAnimals(cell, Wolf, MAX_WOLF_ON_CELL, x, y);
        generateAnimals(cell, Boa, MAX_BOA_ON_CELL, x, y);
        generateAnimals(cell, Fox, MAX_FOX_ON_CELL, x, y);
        generateAnimals(cell, Bear, MAX_BEAR_ON_CELL, x, y);
        generateAnimals(cell, Eagle, MAX_EAGLE_ON_CELL, x, y);
        generateAnimals(cell, Horse, MAX_HORSES_ON_CELL, x, y);
        generateAnimals(cell, Deer, MAX_DEER_ON_CELL, x, y);
        generateAnimals(cell, Rabbit, MAX_RABBIT_ON_CELL, x, y);
        generateAnimals(cell, Mouse, MAX_MOUSE_ON_CELL, x, y);
        generateAnimals(cell, Goat, MAX_GOAT_ON_CELL, x, y);
    }

   private static void generateAnimals(Cell cell, AnimalType animalType, int quantity, int x, int y) {
       Random rnd = new Random();
       int animalTypeCountOnCell = rnd.nextInt(quantity);
       while (animalTypeCountOnCell==0){
           animalTypeCountOnCell = rnd.nextInt(quantity);
       }
       boolean gender;
       for (int i = 0; i < animalTypeCountOnCell - 1; i++) {
            gender = rnd.nextBoolean();
            Gender sex = (gender) ? Gender.MALE : Gender.FEMALE;
            switch (animalType) {
                case Horse:
                    cell.getAnimals().add(new Herbivore.Horse(sex, x, y));
                    break;
                case Boa:
                    cell.getAnimals().add(new Predator.Boa(sex, x, y));
                    break;
                case Wolf:
                    cell.getAnimals().add(new Predator.Wolf(sex, x, y));
                    break;
                case Fox:
                    cell.getAnimals().add(new Predator.Fox(sex, x, y));
                    break;
                case Bear:
                    cell.getAnimals().add(new Predator.Bear(sex, x, y));
                    break;
                case Eagle:
                    cell.getAnimals().add(new Predator.Eagle(sex, x, y));
                    break;
                case Deer:
                    cell.getAnimals().add(new Herbivore.Deer(sex, x, y));
                    break;
                case Rabbit:
                    cell.getAnimals().add(new Herbivore.Rabbit(sex, x, y));
                    break;
                case Mouse:
                    cell.getAnimals().add(new Herbivore.Mouse(sex, x, y));
                    break;
                case Goat:
                    cell.getAnimals().add(new Herbivore.Goat(sex, x, y));
                    break;
            }
        }
    }

    @Override
    public String toString() {
       for (int i = 0; i < getHeight(); i++) {
            System.out.println();
            for (int j = 0; j < getWidth(); j++) {
                System.out.print(animalTypeToGraphic(calcMaxTypeAnimal(cells[i][j])));
                //System.out.print(cells[i][j].animals.size()+"["+i+","+j+"] ");
            }
        }
        return "";
    }
}