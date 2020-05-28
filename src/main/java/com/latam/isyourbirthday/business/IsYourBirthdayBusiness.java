package com.latam.isyourbirthday.business;

import com.latam.isyourbirthday.model.RequestData;
import com.latam.isyourbirthday.model.ResponseData;
import com.latam.isyourbirthday.service.CallRandomPoem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.DateTimeException;

@Component
public class IsYourBirthdayBusiness implements IBirthdayBusiness {

    private RequestData requestData;
    private ResponseData responseData;
    private IsYourBirthdayLogic birthdayLogic;
    private CallRandomPoem callRandomPoem;
    @Autowired
    IsYourBirthdayBusiness(IsYourBirthdayLogic isYourBirthdayLogic, CallRandomPoem randomPoem){
        birthdayLogic = isYourBirthdayLogic;
        callRandomPoem = randomPoem;
    }

    @Override
    public ResponseData execute(String name, String lastName, String motherLastName, String birthday) throws DateTimeException {
        setRequestData(name, lastName, motherLastName, birthday);
        setResponseData();
        return  responseData;
    }

    private void setRequestData(String name, String lastName, String motherLastName, String birthday){
        requestData = new RequestData(name, lastName, motherLastName, birthday);
    }

    private void setResponseData() throws DateTimeException {
        responseData = new ResponseData();
        responseData.setAge(birthdayLogic.obtainsAge(requestData.getBirthday()));
        responseData.setBirthday(birthdayLogic.transformStringDateToLocalDate(requestData.getBirthday()));
        responseData.setAge(birthdayLogic.obtainsAge(requestData.getBirthday()));
        responseData.setNameAndLastName(birthdayLogic.obtainsNameAndLastName(requestData.getNames(),requestData.getLastName()));
        responseData.setDaysRemainingBirthday(birthdayLogic.getPendingDaysToBirthday(requestData.getBirthday()));
        if(birthdayLogic.isYourBirthdayToday(responseData.getDaysRemainingBirthday())){
            responseData.setPoem(callRandomPoem.getPoem().getContent());
        }
    }

}
