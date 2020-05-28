package com.latam.isyourbirthday.business;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class IsYourBirthdayLogicTest {

    @Autowired
    private IsYourBirthdayLogic isYourBirthdayLogic;

    private String name;
    private String lastName;

    @Test
    public void testShouldObtainsNameAndLastName() {
        name = "Americo Salvador";
        lastName = "Faundez";

        String nameAndLastName = isYourBirthdayLogic.obtainsNameAndLastName(name, lastName);

        Assert.assertEquals("Americo Faundez", nameAndLastName);
    }

    @Test
    public void testShouldGetDaysToBirthday() throws ParseException {
        String date = "24-08-1984";

        long pendingDaysToBirthday = isYourBirthdayLogic.getPendingDaysToBirthday(date);

        Assert.assertNotEquals(0, pendingDaysToBirthday);
    }

    @Test
    public void testShouldBirthdayIsToday() throws ParseException {
        Date date = new Date();
        String formatDate = new SimpleDateFormat("dd-MM-yyyy").format(date);

        long pendingDaysToBirthday = isYourBirthdayLogic.getPendingDaysToBirthday(formatDate);

        Assert.assertEquals(0, pendingDaysToBirthday);
    }

    @Test
    public void testShouldGetAge() {
        Date date = new Date();
        String birthday = new SimpleDateFormat("dd-MM-yyyy").format(date);

        int age = isYourBirthdayLogic.obtainsAge(birthday);

        Assert.assertEquals(0, age);
    }

    @Test
    public void testShouldValidMyBirthdayIsToday() {
        int daysToBirthday = 0;

        boolean isMyBirthday = isYourBirthdayLogic.isYourBirthdayToday(daysToBirthday);

        Assert.assertTrue(isMyBirthday);
    }

    @Test
    public void testShouldValidMyBirthdayIsNotToday() {
        int daysToBirthday = 1;

        boolean isMyBirthday = isYourBirthdayLogic.isYourBirthdayToday(daysToBirthday);

        Assert.assertFalse(isMyBirthday);
    }

    @Test
    public void testShouldObtainsLocalDate() {
        LocalDate expectedDate = LocalDate.of(1984, Month.AUGUST, 24);
        String birthday = "24-08-1984";

        LocalDate parseDate = isYourBirthdayLogic.transformStringDateToLocalDate(birthday);

        Assert.assertEquals(expectedDate, parseDate);
    }

    @Test
    public void testShouldArrayIndexOutOfBoundsException() {
        String birthday = "24081984";
        Assert.assertThrows(ArrayIndexOutOfBoundsException.class, ()->{
            isYourBirthdayLogic.transformStringDateToLocalDate(birthday);
        });
    }

    @Test
    public void testShouldDateTimeException() {
        String birthday = "1984-02-31";
        Assert.assertThrows(DateTimeException.class, ()->{
            isYourBirthdayLogic.transformStringDateToLocalDate(birthday);
        });

    }


}
