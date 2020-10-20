package ru.levelup.musicians.library.repository_musician.implmusician;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.levelup.musicians.library.modelmusician.Countries;
import ru.levelup.musicians.library.modelmusician.Genres;
import ru.levelup.musicians.library.repository_musician.GenresRepository;

import java.util.List;

@RequiredArgsConstructor
public class HibernateGenresRepository implements GenresRepository {

    private final SessionFactory factory;


    @Override
    public Genres createGenre(String genre) {
        try (Session session = factory.openSession()){
            Transaction tx = session.beginTransaction();
            Genres newgenre = new Genres();
            newgenre.setGenre(genre);
            session.persist(newgenre);
            System.out.println("new genre: " + newgenre.getGenre_id());
            tx.commit();
            return newgenre;
        }
    }

    @Override
    public void deleteGenrebyName(String genre) {
        try(Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            //Genres genreToDelete = session.get(Genres.class, genre);
            //session.delete(genreToDelete);
            int result = session.createQuery("delete from Genres where genre like :genre")
                    .setParameter("genre", genre).executeUpdate();
            System.out.println("deleted rows: " + result);
            tx.commit();
        }

    }

    @Override
    public List<Genres> findAllgenres() {
        try(Session session = factory.openSession()) {
            List<Genres>genres = session.createQuery("from Genres",Genres.class).getResultList();
            System.out.println(genres);
            return genres;
        }
    }
}
