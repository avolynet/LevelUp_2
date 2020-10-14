package ru.levelup.musicians.library.repository_musician;

import ru.levelup.musicians.library.modelmusician.Countries;

import java.util.List;

public interface CountryRepository {

    // интерфейс доступа к базе
    Countries createNewCountry(String country_name);

    List<Countries> findCountries();
    Countries findCountryByName(String country_name);
    void deleteCountry(int country_id);

}
