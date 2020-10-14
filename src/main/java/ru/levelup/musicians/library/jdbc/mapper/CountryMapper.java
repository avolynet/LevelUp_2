package ru.levelup.musicians.library.jdbc.mapper;

import ru.levelup.musicians.library.model.Country;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryMapper {

    public Country mapResultSet(ResultSet rs) throws SQLException {
        return Country.builder()
                .country_id(rs.getInt(1))
                .country_name(rs.getString(2))
                .build();
    }
}
