package com.latam.isyourbirthday.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ResponseData {

    private String nameAndLastName;
    private LocalDate birthday;
    private int age;
    private long daysRemainingBirthday;
    private String poem;
}
