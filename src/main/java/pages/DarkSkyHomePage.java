package pages;

import org.openqa.selenium.By;

import java.util.ArrayList;

public class DarkSkyHomePage extends Base {

    By currentTemp = By.xpath("//span[@class='summary swap']");
    By timeLineTemp = By.xpath("//span[@class='first']//span");

    By timeListRow = By.xpath("//span[@class='hour']/span");

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
