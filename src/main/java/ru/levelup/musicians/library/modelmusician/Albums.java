package ru.levelup.musicians.library.modelmusician;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
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

    @OneToMany(mappedBy = "albums")
    //@JoinColumn(name = "album_id")
    private List<Songs> songs;


    //public Albums(){};

    @Builder
    public Albums(String album_title, LocalDate album_year){
        //this.album_id = album_id;
        this.album_title = album_title;
        this.album_year = album_year;
    }
}
