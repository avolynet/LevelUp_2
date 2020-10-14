package ru.levelup.musicians.library;

import org.hibernate.SessionFactory;
import ru.levelup.musicians.library.hibernate.HibernateUtils;
import ru.levelup.musicians.library.hibernate.HibernateUtilsMusicians;
import ru.levelup.musicians.library.model.Person;
import ru.levelup.musicians.library.model.PersonLegalInfo;
import ru.levelup.musicians.library.modelmusician.Countries;
import ru.levelup.musicians.library.modelmusician.Musicians;
import ru.levelup.musicians.library.repository.DepositRepository;
import ru.levelup.musicians.library.repository.PersonRepository;
import ru.levelup.musicians.library.repository.impl.HibernateDepositRepository;
import ru.levelup.musicians.library.repository.impl.HibernatePersonRepository;
import ru.levelup.musicians.library.repository_musician.CountryRepository;
import ru.levelup.musicians.library.repository_musician.MusiciansRepository;
import ru.levelup.musicians.library.repository_musician.implmusician.HibernateCountriesRepository;
import ru.levelup.musicians.library.repository_musician.implmusician.HibernateMusiciansRepository;

import java.time.LocalDate;
import java.util.List;

public class TestApp {

    public static void main(String[] args) {
     /*  SessionFactory factory = HibernateUtils.getFactory();
       PersonRepository personRepository = new HibernatePersonRepository(factory);
       DepositRepository depositRepository = new HibernateDepositRepository(factory);


       //PersonLegalInfo legalInfo = personRepository.updateLegalInfo();

       Person person = personRepository.findById(3);
       System.out.println(person);

       Person loadedPerson = personRepository.loadById(3);
       System.out.println("loaded person: " + loadedPerson);


       depositRepository.createDeposit(
               "Sberbook",
               1.2,
               false,
               false,
               10000
       );*/


       /*  personRepository.createNewPerson(
       //         235,
       //         "Oleg",
       //         "Petrov",
       //         "Igorevich",
       //         LocalDate.of(1994, 4, 29)
      //  );
        //detached

        Person byId = personRepository.findById(235);
        System.out.println(byId);

        List<Person> bylastName= personRepository.findBylastName("%ov%");
        System.out.println(bylastName);

        factory.close();*/

        SessionFactory factory = HibernateUtilsMusicians.getFactory();
        CountryRepository countryRepository = new HibernateCountriesRepository(factory);
        MusiciansRepository musiciansRepository = new HibernateMusiciansRepository(factory);


        musiciansRepository.createNewMusician("Kinchev", "Konstantin", "Evgenievich", "m", LocalDate.of(1958,12,25), 1);
        //musiciansRepository.deleteMusicianById(4);

        //List<Musicians> musiciansBySurname = musiciansRepository.findBySurname("Shnurov");
        //System.out.println("Musician" + musiciansBySurname);

        //musiciansRepository.updateMusicianById(2, "Shnurov", "Sergey", "Vladimirovich", "m",LocalDate.of(1973,04,13), 1);


        //countryRepository.createNewCountry("Belarus");
        //Countries countryByName = countryRepository.findCountryByName("Belarus");
        //System.out.println("country: " + countryByName + System.lineSeparator());

        //List <Countries> allCountries = countryRepository.findCountries();
        //System.out.println("all countries: " + allCountries);

        //countryRepository.deleteCountry(4);




    }
}
