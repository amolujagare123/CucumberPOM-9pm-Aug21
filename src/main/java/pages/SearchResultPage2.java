package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static stepdefinitions.SharedSD.getDriver;

public class SearchResultPage2 extends Base {

    By distRowList = By.xpath("//li[contains(text(),'km to city centre')]");


    public ArrayList<Double> getDistanceList()
    {
        ArrayList<String> rowList = getElementTextList(distRowList);
        // 14 km to city centre
        ArrayList<Double> distList = new ArrayList<>();
        for(int i =0 ;i<rowList.size();i++)
        {
          double dist =  Double.parseDouble(rowList.get(i).split(" ")[0]);
            distList.add(dist);
        }
        System.out.println(distList);
        return distList;
    }

}
