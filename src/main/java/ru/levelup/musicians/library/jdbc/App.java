package ru.levelup.musicians.library.jdbc;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
       DepositJdbcService depositJdbcService = new DepositJdbcService();
       //System.out.println(depositJdbcService.findallDeposits());
       CountriesJdbcService countriesJdbcService = new CountriesJdbcService();
       MusiciansJdbcService musiciansJdbcService = new MusiciansJdbcService();

       /* Deposit NewDeposit = depositJdbcService.createNewDeposit(
                "Мечтай", 9.5, true, true, 1000
        );
        System.out.println(NewDeposit);*/

        /*
       Country newCountry = countriesJdbcService.createCountry("Germany");
       System.out.println(newCountry);

       System.out.println(countriesJdbcService.findCountries());
       System.out.println(countriesJdbcService.findCountryByName("Germany"));
       countriesJdbcService.deleteCountry(2);*/

       LocalDate date = LocalDate.of(1973, 4, 13);

       //Musician newMusician = musiciansJdbcService.createMusician("Shnurov", "Sergey", "Vladimirovich", "m",date, 1);
       // System.out.println(musiciansJdbcService.findBySurname("Shnurov"));
        //System.out.println(musiciansJdbcService.updateMusicianbyId("Schnurov", "Ser", "Vladimirovich", "m",date, 1, 1));
        //System.out.println(musiciansJdbcService.deleteMusicianbyId(1));




    }
}
