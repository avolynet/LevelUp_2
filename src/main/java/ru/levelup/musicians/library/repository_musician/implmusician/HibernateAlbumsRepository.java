package ru.levelup.musicians.library.repository_musician.implmusician;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.levelup.musicians.library.modelmusician.Albums;
import ru.levelup.musicians.library.repository_musician.AlbumsRepository;

import javax.management.Query;
import java.time.LocalDate;

@RequiredArgsConstructor
public class HibernateAlbumsRepository implements AlbumsRepository {

    private final SessionFactory factory;
    @Override
    public Albums createNewAlbum(String album_title, LocalDate album_year) {
        try(Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            Albums album = new Albums();
            album.setAlbum_title(album_title);
            album.setAlbum_year(album_year);
            session.persist(album);
            tx.commit();
            System.out.println("album: " + album);
            return album;
        }
    }

    @Override
    public Albums updateAlbumbyId(Integer album_id, String album_title, LocalDate album_year) {
        try(Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            Albums album = session.get(Albums.class, album_id);
            album.setAlbum_title(album_title);
            album.setAlbum_year(album_year);
            session.merge(album);
            tx.commit();
            System.out.println("updated album: " + album);
            return  album;
        }
    }

    @Override
    public Albums findById(Integer album_id) {
        try (Session session = factory.openSession()){
            Albums album = session.get(Albums.class,album_id);
            return album;
        }
    }

    @Override
    public void deleteAlbumbyId(Integer album_id) {
        try(Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            int result = session.createQuery("delete from Albums where album_id =: album_id")
                    .setParameter("album_id", album_id)
                    .executeUpdate();
            tx.commit();
            System.out.println("deleted rows: " + result);




        }

    }
}
