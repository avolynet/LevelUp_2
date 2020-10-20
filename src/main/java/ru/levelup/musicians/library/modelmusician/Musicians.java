package ru.levelup.musicians.library.modelmusician;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@ToString (exclude = "countries")
@Table (name = "musicians")
public class Musicians {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = false)
    private Integer id;
    @Column(name = "surname", nullable = false)
    private String surname;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "patronymic", nullable = false)
    private String patronymic;
    @Column(name = "sex", nullable = false)
    private String sex;
    @Column(name = "born_date", nullable = false)
    private LocalDate born_date;
    @Column(name = "country_id", nullable = false)
    private Integer country_id;

    @ManyToOne
    @JoinTable()
    private Countries country;


    public Musicians (){}

    @Builder
    public Musicians (Integer id, String surname, String name, String patronymic, String sex, LocalDate born_date, Integer country_id){
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.sex = sex;
        this.born_date = born_date;
        this.country_id = country_id;
    }

 /*   public Musicians(String surname) {
        this.surname = surname;
    }

    public Musicians(String surname, String name) {
        this.surname = surname;
        this.name = name;
    }

    public Musicians(Integer country_id) {
        this.country_id = country_id;
    }*/
}
