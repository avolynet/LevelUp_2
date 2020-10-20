package ru.levelup.musicians.library;

import org.hibernate.SessionFactory;
import ru.levelup.musicians.library.hibernate.HibernateUtilsMusicians;
import ru.levelup.musicians.library.modelmusician.Albums;
import ru.levelup.musicians.library.modelmusician.Countries;
import ru.levelup.musicians.library.repository_musician.*;
import ru.levelup.musicians.library.repository_musician.implmusician.*;

import java.time.LocalDate;

public class TestApp {

    public static void main(String[] args) {
        /*SessionFactory factory = HibernateUtils.getFactory();
        PersonRepository personRepository = new HibernatePersonRepository(factory);
        DepositRepository depositRepository = new HibernateDepositRepository(factory);

        BankRepository bankRepository = new HibernateBankRepositoryImpl(factory);

        Bank bank = bankRepository.createBank("CC");
        Person p1 = personRepository.findById(234);
        Person p2 = personRepository.findById(3);

        bankRepository.addClient(bank.getId(), p1);
        bankRepository.addClient(bank.getId(), p2);

        try (Session session = factory.openSession()){
            //session.merge(bank); //detached --> persistence
            bank=session.get(Bank.class, bank.getId());

            List<Person>persons = bank.getBankPersons();
            System.out.println(persons);
        }

        PersonLegalInfo legalInfo = personRepository.updateLegalInfo(235,"4012",
                "543345",
                "11112222",
                "000000011");
        System.out.println(legalInfo);
       // PersonLegalInfo legalInfo = personRepository.getPersonLegalInfo(235);
       // System.out.println(legalInfo);


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
        System.out.println(bylastName);*/



        SessionFactory factory = HibernateUtilsMusicians.getFactory();

        CountryRepository countryRepository = new HibernateCountriesRepository(factory);
        //countryRepository.createNewCountry("Belarus");
        Countries countryByName = countryRepository.findCountryByName("Belarus");
        System.out.println("country: " + countryByName + System.lineSeparator());

        //List <Countries> allCountries = countryRepository.findCountries();
        //System.out.println("all countries: " + allCountries);

        //countryRepository.deleteCountry(6);


        MusiciansRepository musiciansRepository = new HibernateMusiciansRepository(factory);
        //musiciansRepository.createNewMusician("Kinchev", "Konstantin", "Evgenievich", "m", LocalDate.of(1958,12,25), 1);
        //musiciansRepository.deleteMusicianById(4);

        //List<Musicians> musiciansBySurname = musiciansRepository.findBySurname("Shnurov");
        //System.out.println("Musician" + musiciansBySurname);

        //musiciansRepository.updateMusicianById(2, "Shnurov", "Sergey", "Vladimirovich", "m",LocalDate.of(1973,04,13), 1);

        SongsRepository songsRepository = new HibernateSongsRepository(factory);
        //songsRepository.createNewSong(4,"Капитал");
        //songsRepository.findSongbySong_title("Надоел");
        //songsRepository.deleteSongbyId(2);

        GenresRepository genresRepository = new HibernateGenresRepository(factory);
        //genresRepository.createGenre("Classic");
        //genresRepository.deleteGenrebyName("Classic");
        //genresRepository.findAllgenres();

        BandsRepository bandsRepository = new HibernateBandsRepository(factory);
        //bandsRepository.createBand("Lyapis Trubetskoy", "1990 – 2014",5);
        //bandsRepository.deleteBandbyId(2);
        //bandsRepository.findBandByTitle("Kino");

        AlbumsRepository albumsRepository = new HibernateAlbumsRepository(factory);
        //Albums albumById = albumsRepository.findById(3);
        //System.out.println(albumById);
        //albumsRepository.createNewAlbum("Ты кинула", LocalDate.of(1998,01,30));

        //albumsRepository.updateAlbumbyId(1, "Пуля", LocalDate.of(1999,01,01));
        //albumsRepository.deleteAlbumbyId(2);

        factory.close();
    }
}
