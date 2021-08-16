package pages;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;

import static stepdefinitions.SharedSD.getDriver;

public class DarkSkyHomePage extends Base {

    By currentTemp = By.xpath("//span[@class='summary swap']");
    By timeLineTemp = By.xpath("//span[@class='first']//span");

    By timeListRow = By.xpath("//span[@class='hour']/span");

    By todaysExpander = By.xpath("//a[@data-day='0']//span[@class='open']");

    By barMinTemp = By.xpath("//a[@data-day='0']//span[@class='minTemp']"); // 71˚
    By barMaxTemp = By.xpath("//a[@data-day='0']//span[@class='maxTemp']");

    By timelineMinTemp = By.xpath("//div[@class='dayDetails revealed']//span[@class='highTemp swip']//span[@class='temp']");
    By timelineMaxTemp = By.xpath("//div[@class='dayDetails revealed']//span[@class='lowTemp swap']//span[@class='temp']");

    By darkSkyAPI = By.xpath("//a[normalize-space()='Dark Sky API']");

    public void clickDarkSkyAPI()
    {
        clickOn(darkSkyAPI);
    }



    public ArrayList<String> getBarTempList()
    {
        String minTemp = getTextFromElement(barMinTemp).split("˚")[0];
        String maxTemp = getTextFromElement(barMaxTemp).split("˚")[0];

        ArrayList<String> tempList = new ArrayList<>();
        tempList.add(minTemp);
        tempList.add(maxTemp);
        return  tempList;
    }

    public ArrayList<String> getTimelineTempList()
    {
        String minTemp = getTextFromElement(timelineMinTemp).split("˚")[0]; //71˚
        String maxTemp = getTextFromElement(timelineMaxTemp).split("˚")[0];

        ArrayList<String> tempList = new ArrayList<>();
        tempList.add(minTemp);
        tempList.add(maxTemp);
        return  tempList;
    }


    public void clickTodaysExpander()
    {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,1000)");
     //   clickOn(todaysExpander);

        js.executeScript("arguments[0].click();",webAction(todaysExpander));
    }


    public ArrayList<Integer> getTimeListInt()
    {
        ArrayList<String> timeListStr = getElementTextList(timeListRow);
        System.out.println(timeListStr);
        // [11pm, 1am, 3am, 5am, 7am, 9am, 11am, 1pm, 3pm, 5pm, 7pm]

        ArrayList<Integer> timeListInt = new ArrayList<>();

        for(int i=0;i<timeListStr.size();i++)
        {
            String tempStr = timeListStr.get(i); // "11am" "1pm"
            int l = tempStr.length();
            String timeStr = tempStr.substring(0,l-2); // "11"
            int time = Integer.parseInt(timeStr);
            timeListInt.add(time);
        }
        System.out.println(timeListInt);
        return timeListInt;

    }


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
