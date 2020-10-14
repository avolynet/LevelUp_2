package ru.levelup.musicians.library.jdbc.mapper;

import ru.levelup.musicians.library.model.Musician;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MusicianMapper {

    public Musician mapResultSet(ResultSet rs) throws SQLException{
        return  Musician.builder()
                .id(rs.getInt("id"))
                .surname(rs.getString("surname"))
                .name(rs.getString("name"))
                .patronymic(rs.getString("patronymic"))
                .sex(rs.getString("sex"))
                .born_date(rs.getObject("born_date", LocalDate.class))
                .country_id(rs.getInt("country_id"))
                .build();
    }
}
