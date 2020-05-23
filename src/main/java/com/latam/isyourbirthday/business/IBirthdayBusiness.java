package com.latam.isyourbirthday.business;

import com.latam.isyourbirthday.model.ResponseData;

import java.text.ParseException;

public interface IBirthdayBusiness {

    ResponseData execute(String name, String lastName, String motherLastName, String birthday) throws ParseException;
}
