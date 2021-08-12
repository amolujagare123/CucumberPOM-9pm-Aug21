package pages;

import org.openqa.selenium.By;

public class DarkSkyHomePage extends Base {

    By currentTemp = By.xpath("//span[@class='summary swap']");
    By timeLineTemp = By.xpath("//span[@class='first']//span");


    public String getCurrentTemp()
    {
        String tempRaw = getTextFromElement(currentTemp);
        //"90˚ Humid and Mostly Cloudy."
        return tempRaw.split("˚")[0]; // 90
    }

    public String getTimeLineTemp()
    {
        String tempRaw = getTextFromElement(timeLineTemp);
        //"91°"
        return tempRaw.split("°")[0]; // 91
    }

}
