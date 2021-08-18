package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static stepdefinitions.SharedSD.getDriver;

public class SearchResultPage extends Base {

    By starList = By.xpath("//span[contains(@aria-label,'out of 5')]");
    By hotelNames = By.xpath("//span[contains(@class,'sr-hotel__name')]");


    public ArrayList<String> getHotelsList()
    {
        return  getElementTextList(hotelNames);
    }


    public ArrayList<String> getStarList()
    {
        getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        getDriver().navigate().refresh();

        List<WebElement> elementList = getDriver().findElements(starList);

       ArrayList<String> starValueList = new ArrayList<>();
       for(int i=0;i<elementList.size();i++)
       {
          String ariaLabel =  elementList.get(i).getAttribute("aria-label"); // 3 out of 5

           starValueList.add(ariaLabel.split(" ")[0]);
       }

        System.out.println(starValueList);
        System.out.println(starValueList.size());

        return starValueList;
    }


    public void clickStar(String star)
    {
        getDriver().findElement(By.xpath("//div[contains(@data-id,'filter_class')]//a[@data-id='class-"+star+"']")).click();
    }

}
