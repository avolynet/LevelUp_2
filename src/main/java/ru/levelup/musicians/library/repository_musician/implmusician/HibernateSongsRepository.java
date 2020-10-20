package ru.levelup.musicians.library.repository_musician.implmusician;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.levelup.musicians.library.modelmusician.Songs;
import ru.levelup.musicians.library.repository_musician.SongsRepository;

import java.util.List;
@RequiredArgsConstructor
public class HibernateSongsRepository implements SongsRepository {

    private final SessionFactory factory;

    @Override
    public Songs createNewSong(Integer album_id, String song_title) {
        try(Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            Songs song = new Songs();
            song.setAlbum_id(album_id);
            song.setSong_title(song_title);
            session.persist(song);
            System.out.println("Created song: " + song.getSong_id());
            tx.commit();
            return song;
        }

    }

    @Override
    public Songs updateSongbyId(Integer song_id, Integer album_id, String song_title) {
        return null;
    }

    @Override
    public void deleteSongbyId(Integer song_id) {
        try(Session session = factory.openSession()){
            Transaction tx = session.beginTransaction();
            int result = session.createQuery("delete from Songs where song_id =: song_id")
                    .setParameter("song_id", song_id).executeUpdate();
            tx.commit();
            System.out.println("delted rows: " + result);
        }

    }

    @Override
    public List<Songs> findSongbySong_title(String song_title) {
        try(Session session = factory.openSession()) {
            List<Songs> songs = session.createQuery("from Songs where song_title like :song_title", Songs.class)
                    .setParameter("song_title", song_title)
                    .getResultList();
            System.out.println("selected songs: " + songs);
            return songs;
        }
    }
}
