package ru.levelup.musicians.library.model;

import java.time.LocalDate;

import lombok.*;

@Getter
@Setter
@Builder
@ToString

public class Musician {

    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String sex;
    private LocalDate born_date;
    private int country_id;
}
