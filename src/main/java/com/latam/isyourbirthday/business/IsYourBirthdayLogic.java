package com.latam.isyourbirthday.business;

import org.springframework.stereotype.Component;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

@Component
public class IsYourBirthdayLogic {


    public String obtainsNameAndLastName(String name, String lastName) {
        String[] firstName = name.split(" ");
        return new StringBuilder().append(firstName[0]).append(" ").append(lastName).toString();
    }

    public long getPendingDaysToBirthday(String birthdayDate) throws DateTimeException {
        long pendingDaysToBirthday;
        LocalDate localBirthday = transformStringDateToLocalDate(birthdayDate);
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

    public int obtainsAge(String birthdayDate) throws DateTimeException {
    return Period.between(
                transformStringDateToLocalDate(birthdayDate), LocalDate.now()
        ).getYears();
    }

    public boolean isYourBirthdayToday(long daysToBirthday){
        return daysToBirthday == 0;
    }

    public LocalDate transformStringDateToLocalDate(String birthdayDate) throws DateTimeException, IndexOutOfBoundsException {
        String[] date = birthdayDate.split("-");
        return LocalDate.of(Integer.parseInt(date[2]),
                Integer.parseInt(date[1]),
                Integer.parseInt(date[0]));
    }

}
