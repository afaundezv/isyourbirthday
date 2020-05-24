package com.latam.isyourbirthday.controller;

import com.latam.isyourbirthday.business.IBirthdayBusiness;
import com.latam.isyourbirthday.business.IsYourBirthdayBusiness;
import com.latam.isyourbirthday.model.ResponseData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.ParseException;

@RestController
@RequestMapping("/api/")
public class IsYourBirthdayController {

    private IBirthdayBusiness isYourBirthdayBusiness;

    @Autowired
    IsYourBirthdayController(IsYourBirthdayBusiness birthdayBusiness){
        isYourBirthdayBusiness = birthdayBusiness;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value ="v0/birthday")
    public ResponseEntity<ResponseData> isYourBirthday(@RequestParam String name, @RequestParam String lastName,
                                                       @RequestParam String motherLastName, @RequestParam String birthday) throws ParseException {

        ResponseData responseData = isYourBirthdayBusiness.execute(name, lastName, motherLastName, birthday);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

}
