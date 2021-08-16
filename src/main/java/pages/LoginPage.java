package pages;

import org.openqa.selenium.By;

public class LoginPage extends DarkSkyAPIPage{

    By btnLogin = By.xpath("//button[@type='submit']");

    public void clickLoginBtn()
    {
       clickOn(btnLogin);
    }
}
