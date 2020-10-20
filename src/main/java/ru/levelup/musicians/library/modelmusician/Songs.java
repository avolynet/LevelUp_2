package ru.levelup.musicians.library.modelmusician;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString(exclude = "albums")
@Entity
@NoArgsConstructor
@Table(name = "songs")
public class Songs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (nullable = false)
   private Integer song_id;
   @Column(nullable = false, insertable = false, updatable = false)
   private Integer album_id;
   @Column(nullable = false)
   private String song_title;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "album_id")
   private Albums albums;

   //public Songs (){};

   @Builder
   public Songs(Integer song_id, Integer album_id, String song_title){
       this.song_id = song_id;
       this.album_id = album_id;
       this.song_title = song_title;
   }
}
