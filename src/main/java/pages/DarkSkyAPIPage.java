package pages;

import org.openqa.selenium.By;

public class DarkSkyAPIPage extends DarkSkyHomePage{

    By login  = By.xpath("//a[@class='button']");

    public void clickLogin()
    {
        clickOn(login);
    }
}
