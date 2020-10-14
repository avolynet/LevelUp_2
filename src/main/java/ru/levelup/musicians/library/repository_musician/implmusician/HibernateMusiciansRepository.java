package ru.levelup.musicians.library.repository_musician.implmusician;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.levelup.musicians.library.modelmusician.Musicians;
import ru.levelup.musicians.library.repository_musician.MusiciansRepository;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
public class HibernateMusiciansRepository implements MusiciansRepository {

    private final SessionFactory factory;
    @Override
    public Musicians createNewMusician(String surname, String name, String patronymic, String sex, LocalDate born_date, Integer country_id) {
        try(Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            Musicians musician = new Musicians();
            musician.setSurname(surname);
            musician.setName(name);
            musician.setPatronymic(patronymic);
            musician.setSex(sex);
            musician.setBorn_date(born_date);
            musician.setCountry_id(country_id);

            session.persist(musician);

            System.out.println("new Musician: " + musician.getId());
            tx.commit();
            return musician;
        }
    }

    @Override
    public Integer updateMusicianById(Integer id, String newsurname, String newname, String newpatronymic, String newsex, LocalDate newborn_date, Integer newcountry_id) {
        try(Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            Musicians musician = session.get(Musicians.class, id);
            System.out.println("musician was got: " + musician);
            Query query = session.createQuery("update Musicians set surname = :newsurname, name =:newname, patronymic =:newpatronymic, sex =:newsex, born_date =: newborn_date, country_id =: newcountry_id  where id = :id");
            query.setParameter("newsurname",newsurname);
            query.setParameter("newname",newname);
            query.setParameter("newpatronymic",newpatronymic);
            query.setParameter("newsex",newsex);
            query.setParameter("newborn_date",newborn_date);
            query.setParameter("newcountry_id",newcountry_id);
            query.setParameter("id",id);
            int result = query.executeUpdate();
            tx.commit();
            System.out.println("updated rows = " + result);
            return  result;
        }
    }

    @Override
    public Musicians deleteMusicianById(Integer id) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            Musicians musician = session.get(Musicians.class, id);
            session.delete(musician);
            tx.commit();
            System.out.println("following musician was deleted: " + musician);
            return musician;
        }
    }

    @Override
    public List<Musicians> findBySurname(String surname) {
        try(Session session = factory.openSession()) {
          List<Musicians> musicians = (List<Musicians>) session.createQuery("from Musicians where surname like :surname", Musicians.class)
          .setParameter("surname", surname).list();

          return musicians;
        }
    }
}
