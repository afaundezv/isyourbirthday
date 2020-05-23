package com.latam.isyourbirthday.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ResponseData {

    private String nameAndLastName;
    private Date birthday;
    private int age;
    private long daysRemainingBirthday;
    private String poem;
}
