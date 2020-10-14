package ru.levelup.musicians.library.jdbc;

import ru.levelup.musicians.library.jdbc.mapper.MusicianMapper;
import ru.levelup.musicians.library.model.Musician;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;


public class MusiciansJdbcService {

    public JdbcConnectionService jdbcConnectionService;
    private MusicianMapper musicianMapper;

    public MusiciansJdbcService(){
        this.jdbcConnectionService = new JdbcConnectionService();
        this.musicianMapper = new MusicianMapper();
    }

    public Collection<Musician> findBySurname(String m_surname){

      try(Connection connection = jdbcConnectionService.openConnection()) {
          String sql = "select * from musicians where surname = ?";
          PreparedStatement stmt = connection.prepareStatement(sql);

          stmt.setString(1, m_surname);
          ResultSet rs = stmt.executeQuery();
          rs.next();

          Collection<Musician>musicians = new ArrayList<>();
          if(rs.getString("surname").contains(m_surname)){
              musicians.add(musicianMapper.mapResultSet(rs));
          }
          return musicians;

      }catch (SQLException exc){
          throw new RuntimeException("Couldn't execute findBySurname(String m_surname)", exc);
      }

    }

    public Musician createMusician(String m_surname, String m_name, String m_patronymic, String m_sex, LocalDate m_born_date, int m_country_id){
        try(Connection connection = jdbcConnectionService.openConnection()) {

            String sql = "insert into musicians (surname, name, patronymic, sex, born_date, country_id) values ( ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, m_surname);
            stmt.setString(2, m_name);
            stmt.setString(3, m_patronymic);
            stmt.setString(4, m_sex);
            stmt.setObject(5, m_born_date);
            stmt.setInt(6, m_country_id);

            System.out.println("Affected rows: " + stmt.executeUpdate());

            ResultSet idsRS = stmt.getGeneratedKeys();
            idsRS.next();

               int generatedId = idsRS.getInt(1);

               return Musician.builder()
                       .id(generatedId)
                       .surname(m_surname)
                       .name(m_name)
                       .patronymic(m_patronymic)
                       .sex(m_sex)
                       .born_date(m_born_date)
                       .country_id(m_country_id)
                       .build();


        } catch (SQLException exc){
            throw new RuntimeException("Couldn't execute createMusician", exc);
        }

    }

    public Collection<Musician> deleteMusicianbyId (int id){
        String sql = "DELETE FROM musicians WHERE id = ?";

        try (Connection connection = jdbcConnectionService.openConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1,id);
            int affectedrows = stmt.executeUpdate();
            System.out.println("affected rows: " + affectedrows);

            Statement stmt1 = connection.createStatement();
            ResultSet rs = stmt1.executeQuery("SELECT * FROM musicians");

            Collection<Musician>musicians = new ArrayList<>();
            while (rs.next()){
                musicians.add(musicianMapper.mapResultSet(rs));
            }
            return musicians;

        } catch (SQLException exc) {
            throw new RuntimeException("Couldn't execute deleteMusicianbyId", exc);
        }

    }

    public Musician updateMusicianbyId (String m_surname, String m_name, String m_patronymic, String m_sex, LocalDate m_born_date, int m_country_id, int m_id){
        String sql = "UPDATE musicians SET surname = ?, name = ?, patronymic = ?, sex = ?, born_date = ?, country_id = ?  WHERE id = ?";
        String sql1 = "SELECT * from musicians where id = ?";

        try (Connection connection = jdbcConnectionService.openConnection()){
        PreparedStatement stmt = connection.prepareStatement(sql);


        stmt.setString(1,m_surname);
        stmt.setString(2,m_name);
        stmt.setString(3,m_patronymic);
        stmt.setString(4,m_sex);
        stmt.setObject(5,m_born_date);
        stmt.setInt(6,m_country_id);
        stmt.setInt(7,m_id);


        int affectedRows = stmt.executeUpdate();
            System.out.println("affected rows: " + affectedRows);

         PreparedStatement stmt1 = connection.prepareStatement(sql1);
         stmt1.setInt(1,m_id);
         ResultSet rs1 = stmt1.executeQuery();
         rs1.next();

        /* Collection<Musician>musicians = new ArrayList<>();
         while (rs1.next()){
             musicians.add(musicianMapper.mapResultSet(rs1));
         }
            return  musicians;*/

            Musician updatedMusician = musicianMapper.mapResultSet(rs1);
            return updatedMusician;


        }catch (SQLException exc){
            throw new RuntimeException("Couldn't execute updateMusicianbyId" + exc);
        }




    }


 }


