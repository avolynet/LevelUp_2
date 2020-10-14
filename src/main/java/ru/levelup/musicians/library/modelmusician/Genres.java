package ru.levelup.musicians.library.modelmusician;

import lombok.*;

import javax.persistence.*;

@Table(name = "genres")
@Setter
@Getter
//@NoArgsConstructor
@ToString
public class Genres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id", nullable = false)
    private Integer genre_id;
    @Column(name = "genre", nullable = false)
    private String genre;

    public Genres (){};

    @Builder
    public Genres (Integer genre_id, String genre){
        this.genre_id = genre_id;
        this.genre = genre;
    }
}
