package AnimalIsland;

import java.util.*;

import static AnimalIsland.AnimalType.*;
import static AnimalIsland.Properties.*;
import static AnimalIsland.Service.*;

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

    public static void populateIsland(Island myIsland) {
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
        generateAnimals(cell, Horse, MAX_HORSES_ON_CELL, x, y);
        generateAnimals(cell, Wolf, MAX_WOLF_ON_CELL, x, y);
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
                case Wolf:
                    cell.getAnimals().add(new Predator.Wolf(sex, x, y));
                    break;
            }
        }
    }

  /*   public static void generateAnimalsByPairing(Cell cell, AnimalType animalType, int quantity) {
        Random rnd = new Random();
        boolean gender;
        for (int i = 0; i < quantity; i++) {
            gender = rnd.nextBoolean();
            switch (animalType) {
                case Horse:
                    int horse_child_count = rnd.nextInt(HORSE_MAX_CHILDREN);
                    for (int j = 0; j < horse_child_count; j++) {
                        Gender sex = (gender) ? Gender.MALE : Gender.FEMALE;
                        cell.animals.add(new Herbivore.Horse(i, sex, cell.getX(), cell.getY()));
                    }
                    break;
                case Wolf:
                    int wolf_child_count = rnd.nextInt(WOLF_MAX_CHILDREN);
                    for (int j = 0; j < wolf_child_count; j++) {
                        Gender sex = (gender) ? Gender.MALE : Gender.FEMALE;
                        cell.animals.add(new Predator.Wolf(i, sex, cell.getX(), cell.getX()));
                    }
                    break;
            }
        }
    }*/

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



//System.out.print("[" + cell.getX() + "," + cell.getY() + "](" + cell.animals.size() + ")  {"+calcMaxTypeAnimal(cell)+"} ");
/*            Iterator<Animal> itA = cell.animals.iterator();
            for (Iterator<Animal> iter = itA; iter.hasNext(); ) {
                Animal a = iter.next();
                System.out.print(calcMaxTypeAnimal(cell)+" "); */ //getClass().getSimpleName()+