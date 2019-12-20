package ar.com.ada.maven.model.dto;

public class Zoo {

    private Integer id;
    private String name;
    private String size;
    private Double budget;
    private City city;

    public Zoo() {
    }

    public Zoo(Integer id, String name, String size, Double budget, City city) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.budget = budget;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Zoo {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", budget=" + budget +
                ", city=" + city +
                " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Zoo zoo = (Zoo) o;

        return id.equals(zoo.id) &&
                name.equals(zoo.name) &&
                size.equals(zoo.size) &&
                budget.equals(zoo.budget) &&
                city.equals(zoo.city);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + size.hashCode();
        result = 31 * result + budget.hashCode();
        result = 31 * result + city.hashCode();
        return result;
    }
}
