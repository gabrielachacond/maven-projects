package ar.com.ada.maven.model.dto;

public class Kind {

    private Integer id;
    private String commonName;
    private String scientificName;
    private Boolean endangered;
    private Family family;

    public Kind() {
    }

    public Kind(Integer id, String commonName, String scientificName, Boolean endangered, Family family) {
        this.id = id;
        this.commonName = commonName;
        this.scientificName = scientificName;
        this.endangered = endangered;
        this.family = family;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public Boolean getEndangered() {
        return endangered;
    }

    public void setEndangered(Boolean endangered) {
        this.endangered = endangered;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    @Override
    public String toString() {
        return "Kind {" +
                "id=" + id +
                ", commonName='" + commonName + '\'' +
                ", scientificName='" + scientificName + '\'' +
                ", endangered=" + endangered +
                ", family=" + family +
                " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Kind kind = (Kind) o;

        return id.equals(kind.id) &&
                commonName.equals(kind.commonName) &&
                commonName.equals(kind.commonName) &&
                scientificName.equals(kind.scientificName) &&
                endangered.equals(kind.endangered) &&
                family.equals(kind.family);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + commonName.hashCode();
        result = 31 * result + scientificName.hashCode();
        result = 31 * result + endangered.hashCode();
        result = 31 * result + family.hashCode();
        return result;
    }
}
