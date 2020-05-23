package com.latam.isyourbirthday.business;

import com.latam.isyourbirthday.model.Poem;
import com.latam.isyourbirthday.model.Poet;
import com.latam.isyourbirthday.model.ResponseData;
import com.latam.isyourbirthday.service.CallRandomPoem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class IsYourBirthdayBusinessTest {

    @MockBean
    private IsYourBirthdayLogic birthdayLogic;
    @MockBean
    private CallRandomPoem callRandomPoem;
    @Autowired
    private IBirthdayBusiness birthdayBusiness;

    private String name = "Américo Salvador";
    private String lastName = "Faúndez";
    private String motherLastName = "valdebenito";
    private String birthday = "";

    @Before
    public void setUp() {
        birthdayBusiness = new IsYourBirthdayBusiness(birthdayLogic, callRandomPoem);
    }

    @Test
    public void testShouldCreateResponseData() throws ParseException {
        birthday = "24-08-1984";

        ResponseData responseData = birthdayBusiness.execute(name, lastName, motherLastName, birthday);

        Assert.assertNotNull(responseData);

    }

    @Test
    public void testShouldCreateResponseDataWhenIsYourBirthday() throws ParseException {
        Date date = new Date();
        String birthday = new SimpleDateFormat("dd-MM-yyyy").format(date);
        when(birthdayLogic.isYourBirthdayToday(0)).thenReturn(true);
        Poem poem = new Poem("", "mi poema chin chin", "", new Poet());
        when(callRandomPoem.getPoem()).thenReturn(poem);

        ResponseData responseData = birthdayBusiness.execute(name, lastName, motherLastName, birthday);

        Assert.assertNotNull(responseData);

    }

}
