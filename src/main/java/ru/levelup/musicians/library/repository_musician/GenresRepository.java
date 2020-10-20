package ru.levelup.musicians.library.repository_musician;

import ru.levelup.musicians.library.modelmusician.Genres;

import java.util.List;

public interface GenresRepository {
    Genres createGenre(String genre);
    void deleteGenrebyName(String genre);
    List<Genres>findAllgenres();

}
