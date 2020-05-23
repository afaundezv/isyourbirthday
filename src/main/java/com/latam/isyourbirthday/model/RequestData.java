package com.latam.isyourbirthday.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RequestData {

    private String names;
    private String lastName;
    private String motherLastName;
    private String birthday;

}
