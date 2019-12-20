package ar.com.ada.maven.model.dao;

import ar.com.ada.maven.model.DBConnection;
import ar.com.ada.maven.model.dto.Continent;
import ar.com.ada.maven.model.dto.Country;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CountryDAO implements Dao<Country> {

    private ContinentDAO continentDAO = new ContinentDAO(false);
    @Override
    public ArrayList<Country> findAll() {
        String sql = "SELECT * FROM Country";
        ArrayList<Country> countries = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                // con el campo Continent_id busco el continente con el dao de Continent
                Continent contient = continentDAO.findById(rs.getInt("Continent_id"));
                Country country = new Country(rs.getInt("id"), rs.getString("name"), contient);
                countries.add(country);
            }
            connection.close();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }
        return countries;
    }

    @Override
    public Country findById(Integer id) {
        return null;
    }

    @Override
    public Boolean save(Country country) {
        return null;
    }

    @Override
    public Boolean update(Country country, Integer id) {
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        return null;
    }
}
