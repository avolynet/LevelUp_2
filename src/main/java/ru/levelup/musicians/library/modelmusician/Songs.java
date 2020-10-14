package ru.levelup.musicians.library.modelmusician;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Table(name = "songs")
public class Songs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (nullable = false)
   private Integer song_id;
   @Column(nullable = false)
   private Integer album_id;
   @Column(nullable = false)
   private String song_title;

   public Songs (){};

   @Builder
   public Songs(Integer song_id, Integer album_id, String song_title){
       this.song_id = song_id;
       this.album_id = album_id;
       this.song_title = song_title;
   }
}
