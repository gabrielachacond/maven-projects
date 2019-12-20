package ar.com.ada.maven.model.dto;

public class Country {

    private Integer id;
    private String name;
    // Continent_id
    private Continent continent;

    public Country() {
    }

    public Country(Integer id, String name, Continent continent) {
        this.id = id;
        this.name = name;
        this.continent = continent;
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

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    @Override
    public String toString() {
        return "Country {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", continent=" + continent +
                " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        return id.equals(country.id) &&
                name.equals(country.name) &&
                continent.equals(country.continent);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + continent.hashCode();
        return result;
    }
}
