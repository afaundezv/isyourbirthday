package com.latam.isyourbirthday.business;

import com.latam.isyourbirthday.model.RequestData;
import com.latam.isyourbirthday.model.ResponseData;
import com.latam.isyourbirthday.service.CallRandomPoem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class IsYourBirthdayBusiness implements IBirthdayBusiness {

    private RequestData requestData;
    private IsYourBirthdayLogic birthdayLogic;
    private CallRandomPoem callRandomPoem;
    @Autowired
    IsYourBirthdayBusiness(IsYourBirthdayLogic isYourBirthdayLogic, CallRandomPoem randomPoem){
        birthdayLogic = isYourBirthdayLogic;
        callRandomPoem = randomPoem;
    }

    @Override
    public ResponseData execute(String name, String lastName, String motherLastName, String birthday) throws ParseException {
        this.requestData = new RequestData(name, lastName, motherLastName, birthday);
        return createResponseData();
    }

    private ResponseData createResponseData() throws ParseException {
        ResponseData responseData = new ResponseData();
        responseData.setAge(birthdayLogic.obtainsAge(requestData.getBirthday()));
        responseData.setBirthday(birthdayLogic.parseDate(requestData.getBirthday(), "dd-MM-yyyy"));
        responseData.setAge(birthdayLogic.obtainsAge(requestData.getBirthday()));
        responseData.setNameAndLastName(birthdayLogic.obtainsNameAndLastName(requestData.getNames(),requestData.getLastName()));
        responseData.setDaysRemainingBirthday(birthdayLogic.getPendingDaysToBirthday(requestData.getBirthday()));
        if(birthdayLogic.isYourBirthdayToday(responseData.getDaysRemainingBirthday())){
            responseData.setPoem(callRandomPoem.getPoem().getContent());
        }
        return responseData;
    }

}
