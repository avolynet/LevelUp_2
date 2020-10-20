package ru.levelup.musicians.library.repository_musician;

import ru.levelup.musicians.library.modelmusician.Songs;

import java.util.List;

public interface SongsRepository {
    Songs createNewSong(Integer album_id, String song_title);
    Songs updateSongbyId(Integer song_id, Integer album_id, String song_title);
    void deleteSongbyId(Integer song_id);
    List<Songs> findSongbySong_title(String song_title);
}
