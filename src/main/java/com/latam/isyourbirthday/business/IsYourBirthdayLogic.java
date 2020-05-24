package com.latam.isyourbirthday.business;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class IsYourBirthdayLogic {


    public String obtainsNameAndLastName(String name, String lastName) {
        String[] firstName = name.split(" ");
        return new StringBuilder().append(firstName[0]).append(" ").append(lastName).toString();
    }

    public long getPendingDaysToBirthday(String birthdayDate) throws ParseException {
        long pendingDaysToBirthday;
        LocalDate localBirthday = transformDateToLocalDate(birthdayDate);
        LocalDate today = LocalDate.now();
        LocalDate nextBDay = localBirthday.withYear(today.getYear());
        if (nextBDay.isBefore(today) || nextBDay.isEqual(today)) {
            nextBDay = nextBDay.plusYears(1);
        }
        long totalDias = ChronoUnit.DAYS.between(today, nextBDay);
        if (totalDias == 365) {
            pendingDaysToBirthday = 0;
        } else {
            pendingDaysToBirthday = totalDias;
        }
        return pendingDaysToBirthday;
    }

    public int obtainsAge(String birthdayDate) throws ParseException {
        LocalDate today = LocalDate.now();
        LocalDate localBirthday = transformDateToLocalDate(birthdayDate);
        Period age = Period.between(localBirthday, today);
        return age.getYears();
    }

    public boolean isYourBirthdayToday(long daysToBirthday){
        return daysToBirthday == 0;
    }

    public Date parseDate(String birthday, String pattern) throws ParseException {
        return new SimpleDateFormat(pattern).parse(birthday);
    }

    private LocalDate transformDateToLocalDate(String birthdayDate) throws ParseException {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Instant instant = parseDate(birthdayDate, "dd-MM-yyyy").toInstant();
        return instant.atZone(defaultZoneId).toLocalDate();
    }


}
