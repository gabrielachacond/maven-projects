package ar.com.ada.maven.model.dto;

import java.util.Date;

public class Animal {

    private Integer id;
    private char sex;
    private Date birthday;
    private Country country;
    private Kind kind;

    public Animal() {
    }

    public Animal(Integer id, char sex, Date birthday, Country country, Kind kind) {
        this.id = id;
        this.sex = sex;
        this.birthday = birthday;
        this.country = country;
        this.kind = kind;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Kind getKind() {
        return kind;
    }

    public void setKind(Kind kind) {
        this.kind = kind;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal that = (Animal) o;

        return sex != that.sex &&
                id.equals(that.id) &&
                birthday.equals(that.birthday) &&
                country.equals(that.country) &&
                kind.equals(that.kind);
    }
}
