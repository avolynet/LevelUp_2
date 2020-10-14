package ru.levelup.musicians.library.modelmusician;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Table(name = "bands")
public class Bands {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer band_id;
    @Column(nullable = false)
    private String band_title;
    @Column(nullable = false)
    private String years_active;
    @Column(nullable = false)
    private Integer country_id;

    public Bands (){};

    @Builder
    public Bands (Integer band_id, String band_title, String years_active, Integer country_id){
        this.band_id = band_id;
        this.band_title = band_title;
        this.years_active = years_active;
        this.country_id = country_id;
    }

}
