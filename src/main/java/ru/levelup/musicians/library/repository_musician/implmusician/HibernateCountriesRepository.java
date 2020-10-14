package ru.levelup.musicians.library.repository_musician.implmusician;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.levelup.musicians.library.modelmusician.Countries;
import ru.levelup.musicians.library.repository_musician.CountryRepository;

import java.util.List;

@RequiredArgsConstructor
public class HibernateCountriesRepository implements CountryRepository {

    private final SessionFactory factory;

    @Override
    public Countries createNewCountry(String country_name) {

        try(Session session = factory.openSession()){
            Transaction tx = session.beginTransaction();
            Countries country = new Countries(country_name);

            session.save(country);
            tx.commit();
            return country;
        }
    }

    @Override
    public List<Countries> findCountries() {
        try(Session session = factory.openSession()){
            List<Countries>countries = (List<Countries>) session.createQuery("From Countries").list();
            return countries;
        }
    }

    @Override
    public Countries findCountryByName(String country_name) {
        try(Session session = factory.openSession()) {
            return session.createQuery("from Countries where country_name like :country_name", Countries.class)
                    .setParameter("country_name", country_name)
                    .getSingleResult();
        }
    }

    @Override
    public void deleteCountry(int country_id) {
        try(Session session = factory.openSession()){
            Transaction tx = session.beginTransaction();
            Countries country = session.get(Countries.class, country_id);
            session.delete(country);
            tx.commit();
        }
    }
}
