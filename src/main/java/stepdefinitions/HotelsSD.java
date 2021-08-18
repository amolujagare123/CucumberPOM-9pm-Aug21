package stepdefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.SearchResultPage;
import pages.SearchResultPage2;

import java.util.ArrayList;

public class HotelsSD {
    SearchResultPage searchResultPage = new SearchResultPage();
    SearchResultPage2 searchResultPage2 = new SearchResultPage2();
    @Then("^I verify system displays all hotels within \"([^\"]*)\" Km radius of center$")
    public void i_verify_system_displays_all_hotels_within_something_km_radius_of_center(String distStr) throws Throwable {

        double expectedDist = Double.parseDouble(distStr);

        ArrayList<Double> distList = searchResultPage2.getDistanceList();
        boolean flag =true;
        for(int i=0;i<distList.size();i++)
        {
            if(distList.get(i)>expectedDist)
            {
                flag = false;
            }

        }

        Assert.assertTrue("some distances are greater than:"+expectedDist,flag);
    }


    @Then("^I verify \"([^\"]*)\" is within radius$")
    public void i_verify_something_is_within_radius(String hotelName) throws Throwable {

        ArrayList<String> hotelList = searchResultPage.getHotelsList();

        for(int i=0;i<hotelList.size();i++)
        System.out.println(hotelList.get(i));

        boolean result = hotelList.contains(hotelName);

        Assert.assertTrue(hotelName+": this hotel is not in the search result",result);
    }

}
