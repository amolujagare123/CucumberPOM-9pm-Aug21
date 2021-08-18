package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SearchResultPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import static stepdefinitions.SharedSD.getDriver;

public class HotelsStarVerifySD {

    SearchResultPage searchResultPage = new SearchResultPage();

    @Given("^I am on default locations search result screen$")
    public void i_am_on_default_locations_search_result_screen() throws Throwable {
        /*Assert.assertEquals("This is not a search result screen",
                "Booking.com : Hotels in Goa . Book your hotel now!",
                getDriver().getTitle() );*/
    }

    @When("^I select property class (.+)$")
    public void i_select_property_class(String stars) throws Throwable {
 // 5 stars -->
        getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        searchResultPage.clickStar(stars.split(" ")[0]);


    }

    @Then("^I verify system displays only (.+) hotels on search result$")
    public void i_verify_system_displays_only_hotels_on_search_result(String stars) throws Throwable {

        String star = stars.split(" ")[0];

        ArrayList<String> startList = searchResultPage.getStarList(); // 4

        int occurance = Collections.frequency(startList,star);
        int size = startList.size();

        boolean result = occurance == size;

        Assert.assertTrue("all the hotels are not "+star+" Stars",result);
    }
}
