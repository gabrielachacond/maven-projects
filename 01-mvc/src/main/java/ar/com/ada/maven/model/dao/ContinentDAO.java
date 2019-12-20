package ar.com.ada.maven.model.dao;

import ar.com.ada.maven.model.DBConnection;
import ar.com.ada.maven.model.dto.Continent;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContinentDAO implements Dao<Continent>  {

    private Boolean willCloseConnection = true;

    public ContinentDAO() {
    }

    public ContinentDAO(Boolean willCloseConnection) {
        this.willCloseConnection = willCloseConnection;
    }

    @Override
    public List<Continent> findAll() {
        String sql = "SELECT * FROM Continent";
        List<Continent> continents = new ArrayList<>();

        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Continent continent = new Continent(rs.getInt("id"), rs.getString("name"));
                continents.add(continent);
            }
            connection.close();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }

        return continents;
    }

    @Override
    public Continent findById(Integer id) {
        String sql = "SELECT * FROM Continent WHERE id = ?";
        Continent continent = null;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next())
                continent = new Continent(rs.getInt("id"), rs.getString("name"));

            if (willCloseConnection)
                connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }

        return continent;
    }

    @Override
    public Boolean save(Continent continent) {
        String sql = "INSERT INTO Continent (name) VALUES (?)";
        int hasInsert = 0;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, continent.getName());
            hasInsert = preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }
        return hasInsert == 1;
    }

    @Override
    public Boolean update(Continent continent, Integer id) {
        String sql = "UPDATE Continent SET name = ? WHERE id = ?";
        int hasUpdate = 0;

        // validacion de actualizacion
        Continent continentDB = findById(id);

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, continent.getName());
            preparedStatement.setInt(2, id);

            if (!continent.getName().equals(continentDB.getName()))
                hasUpdate = preparedStatement.executeUpdate();

            connection.close();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }

        return hasUpdate == 1;
    }

    @Override
    public Boolean delete(Integer id) {
        String sql = "DELETE Continent WHERE id = ?";
        int hasDelete = 0;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            hasDelete = preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }
        return hasDelete == 1;
    }
}
