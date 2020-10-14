package ru.levelup.musicians.library.modelmusician;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Table(name = "albums")
public class Albums {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id", nullable = false)
    private Integer album_id;
    @Column(name = "album_title", nullable = false)
    private String album_title;
    @Column(name = "album_year", nullable = false)
    private LocalDate album_year;

    public Albums (){};

    @Builder
    public Albums(Integer album_id, String album_title, LocalDate album_year){
        this.album_id = album_id;
        this.album_title = album_title;
        this.album_year = album_year;
    }
}
