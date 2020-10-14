package ru.levelup.musicians.library.jdbc;

import ru.levelup.musicians.library.jdbc.mapper.CountryMapper;
import ru.levelup.musicians.library.model.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class CountriesJdbcService {

    public JdbcConnectionService jdbcConnectionService;
    private CountryMapper countryMapper;

    public CountriesJdbcService(){
        this.jdbcConnectionService = new JdbcConnectionService();
        this.countryMapper = new CountryMapper();
    }

    public Collection<Country> findCountries(){
        try (

            Connection connection = jdbcConnectionService.openConnection()) {
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("select * from countries");

                Collection<Country>countries = new ArrayList<>();
                while (rs.next()){
                    countries.add(countryMapper.mapResultSet(rs));
                }
                return countries;

        }catch (SQLException exc){
            throw new RuntimeException("Couldn't execute findCountries", exc);
        }

    }

    public Collection<Country> findCountryByName(String c_name){

        try (Connection connection = jdbcConnectionService.openConnection()) {
            String sql = "select * from countries where country_name = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, c_name);

            ResultSet rs = stmt.executeQuery();
            rs.next();

            Collection<Country>countries = new ArrayList<>();
            if (rs.getString("country_name").contains(c_name)){
                countries.add(countryMapper.mapResultSet(rs));
            }
            return countries;

        }catch (SQLException exc){
            throw new RuntimeException("Couldn't execute findCountryByName(String name)", exc);
        }
    }

    public Country createCountry (String country_name){

        try(Connection connection = jdbcConnectionService.openConnection()){

            String sql = "insert into countries (country_name) values (?)";
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, country_name);
            int affectedRows = stmt.executeUpdate();
            System.out.println("affected rows "+ affectedRows);

            ResultSet keysRS = stmt.getGeneratedKeys();
            keysRS.next();
            int generatedKey = keysRS.getInt(1);

            return Country.builder()
                    .country_id(generatedKey)
                    .country_name(country_name)
                    .build();

        }catch (SQLException exc) {
            throw new RuntimeException("Couldn't execute createCountry", exc);
        }

    }

    public void deleteCountry (int country_id){

        try(Connection connection = jdbcConnectionService.openConnection()){

            String sql = "delete from countries where country_id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, country_id);
            int affectedRows = stmt.executeUpdate();
            System.out.println("affected rows "+ affectedRows);

            Statement stmt1 = connection.createStatement();
            ResultSet rs = stmt1.executeQuery("select * from countries");

            /*Collection<Country>countries = new ArrayList<>();
            while (rs.next()){
                countries.add(countryMapper.mapResultSet(rs));
            }
            return countries;*/

        }catch (SQLException exc) {
            throw new RuntimeException("Couldn't execute deleteCountry", exc);
        }

    }

}
