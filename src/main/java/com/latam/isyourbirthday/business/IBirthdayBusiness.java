package com.latam.isyourbirthday.business;

import com.latam.isyourbirthday.model.ResponseData;

import java.time.DateTimeException;

public interface IBirthdayBusiness {

    ResponseData execute(String name, String lastName, String motherLastName, String birthday) throws DateTimeException;
}
