package ru.levelup.musicians.library.repository_musician;

import ru.levelup.musicians.library.modelmusician.Albums;

import java.time.LocalDate;

public interface AlbumsRepository {

    Albums createNewAlbum(String album_title, LocalDate album_year);
    Albums updateAlbumbyId(Integer album_id, String album_title, LocalDate album_year);
    Albums findById(Integer album_id);
    void deleteAlbumbyId(Integer album_id);

}
