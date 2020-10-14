package ru.levelup.musicians.library.repository_musician;

import ru.levelup.musicians.library.modelmusician.Musicians;

import java.time.LocalDate;
import java.util.List;

public interface MusiciansRepository {

    Musicians createNewMusician(String surname, String name, String patronymic, String sex, LocalDate born_date, Integer country_id);
    Integer updateMusicianById(Integer id, String newsurname, String newname, String newpatronymic, String newsex, LocalDate newborn_date, Integer newcountry_id);
    Musicians deleteMusicianById(Integer id);
    List<Musicians> findBySurname (String surname);

}
