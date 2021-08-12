package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.DarkSkyHomePage;

import static stepdefinitions.SharedSD.getDriver;

public class DarkSkySD {

    DarkSkyHomePage darkSkyHomePage = new DarkSkyHomePage();

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
}
