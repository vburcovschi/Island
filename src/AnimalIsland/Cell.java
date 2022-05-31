package AnimalIsland;

import java.util.Set;

public class Cell {
    private Set<Animal> animals;

    public Cell(Set<Animal> animals) {
        this.animals = animals;
    }


    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }
}
