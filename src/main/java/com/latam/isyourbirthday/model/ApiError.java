package com.latam.isyourbirthday.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiError {

    private int code;
    private String message;
    private String error;
}
