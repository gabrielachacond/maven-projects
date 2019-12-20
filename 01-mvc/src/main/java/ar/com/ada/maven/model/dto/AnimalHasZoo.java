package ar.com.ada.maven.model.dto;

public class AnimalHasZoo {
    private Animal animal;
    private Zoo zoo;

    public AnimalHasZoo() {
    }

    public AnimalHasZoo(Animal animal, Zoo zoo) {
        this.animal = animal;
        this.zoo = zoo;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnimalHasZoo that = (AnimalHasZoo) o;

        return animal.equals(that.animal) && zoo.equals(that.zoo);
    }

    @Override
    public int hashCode() {
        int result = animal.hashCode();
        result = 31 * result + zoo.hashCode();
        return result;
    }
}
