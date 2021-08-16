package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DarkSkyHomePage;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.Collections;

import static stepdefinitions.SharedSD.getDriver;

public class DarkSkySD {

    DarkSkyHomePage darkSkyHomePage = new DarkSkyHomePage();
    LoginPage loginPage = new LoginPage();
    @Given("^I am on Darksky Home Page$")
    public void i_am_on_darksky_home_page() throws Throwable {
        Assert.assertEquals("This is not a darksky home page",
                "Dark Sky - Sansad Marg, New Delhi, Delhi",
               getDriver().getTitle() );
    }

    @Then("^I verify current temp is equal to Temperature from Daily Timeline$")
    public void i_verify_current_temp_is_equal_to_temperature_from_daily_timeline() throws Throwable {

        String expected = darkSkyHomePage.getCurrentTemp();
        String actual = darkSkyHomePage.getTimeLineTemp();

        System.out.println("Expected="+expected);
        System.out.println("Actual="+actual);

        Assert.assertEquals("difference in temprature",
                            expected,actual);

    }

    @Then("^I verify timeline is displayed with two hours incremented$")
    public void i_verify_timeline_is_displayed_with_two_hours_incremented() throws Throwable {

        ArrayList<Integer> timeList = darkSkyHomePage.getTimeListInt();

        // [11, 1, 3, 5, 7, 9, 11, 1, 3, 5, 7] --> 11 elements

        ArrayList<Integer> timeDiffList = new ArrayList<>();

        for(int i=0;i<timeList.size()-1;i++)
        {
            int time1 = timeList.get(i);
            int time2 = timeList.get(i+1);
            int timeDiff = 0;

            if(time2>time1)
                timeDiff = time2 - time1;
            if(time1>time2)
                timeDiff = (time2+12) - time1; // 11 , 1 --> 11, 1 +12

            timeDiffList.add(timeDiff);

        }

        System.out.println(timeDiffList);

        int size = timeDiffList.size();

        int occurance = Collections.frequency(timeDiffList,2);

        boolean result = (size == occurance); // true /false

        System.out.println("occurance="+occurance);
        System.out.println("size="+size);

        Assert.assertTrue("all the differences are not '2'",result);

    }

    @Then("^I verify today's lowest and highest temp is displayed correctly$")
    public void i_verify_todays_lowest_and_highest_temp_is_displayed_correctly() throws Throwable {

        darkSkyHomePage.clickTodaysExpander();

        ArrayList<String> expected = darkSkyHomePage.getBarTempList();
        ArrayList<String> actual = darkSkyHomePage.getTimelineTempList();

        System.out.println("Expected="+expected);
        System.out.println("Actual="+actual);

        Assert.assertEquals("wrong temperatures",expected,actual);
    }

    @Given("^I am on the darksky Login page$")
    public void i_am_on_the_darksky_login_page() throws Throwable {

        loginPage.clickDarkSkyAPI();
        loginPage.clickLogin();


    }



    @When("^I click on Login button$")
    public void i_click_on_login_button() throws Throwable {

        loginPage.clickLoginBtn();
    }

    @Then("^I verify I am on Login page by asserting Login page title$")
    public void i_verify_i_am_on_login_page_by_asserting_login_page_title() throws Throwable {

        String expected = "Dark Sky API: Log In";
        String actual = getDriver().getTitle();
        System.out.println("Expected="+expected);
        System.out.println("Actual="+actual);

        Assert.assertEquals("this is not a login page",expected,actual);
    }
}
