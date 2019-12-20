package ar.com.ada.maven;

import ar.com.ada.maven.model.dao.ContinentDAO;
import ar.com.ada.maven.model.dao.CountryDAO;
import ar.com.ada.maven.model.dto.Continent;
import ar.com.ada.maven.model.dto.Country;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {


        ContinentDAO dao = new ContinentDAO();
        CountryDAO countryDao = new CountryDAO();
//        List<Continent> continentList = dao.findAll();
//
//        // Lambda
//        continentList.forEach(continent -> System.out.println(continent.toString()));

        // get by ID
//        Continent continent = dao.findById(2);
//        if (continent != null)
//            System.out.println(continent.toString());

        // update
//        Continent continentUpdate = new Continent("América");
//        Integer idUpdate = 2;
//        Boolean hasUpdate = dao.update(continentUpdate, idUpdate);
//        if (hasUpdate)
//            System.out.println("Se actualizo el registro " + idUpdate);
//        else
//            System.out.println("NO se pudo realizar la actualizacion");

        ArrayList<Country> countries = countryDao.findAll();

        countries.forEach(country -> {
            String coun = country.getName();
            String cont = country.getContinent().getName();
            System.out.println("Continete: " + cont + " Pais: " + coun);
        });

        countries.forEach(country -> System.out.println(country.toString()));

    }
}
