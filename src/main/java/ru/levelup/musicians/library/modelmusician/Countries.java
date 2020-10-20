package ru.levelup.musicians.library.modelmusician;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

//hibernate
@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table (name = "countries")
public class Countries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "country_id", nullable = false)
    private Integer country_id;

    @Column (name = "country_name", nullable = false)
    private String country_name;

    @OneToMany(mappedBy = "countries", fetch = FetchType.EAGER)
    private List<Bands>bands;


    public Countries(String country_name) {
        this.country_name = country_name;
    }
}
