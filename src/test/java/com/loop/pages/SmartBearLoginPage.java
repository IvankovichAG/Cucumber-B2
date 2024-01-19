package com.loop.pages;

import com.loop.utilities.BrowserUtils;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SmartBearLoginPage extends SmartBearBasePage{

    @FindBy(css = "input[type='text']") public WebElement username;
    @FindBy (css = "input[type='password']") public WebElement password;
    @FindBy (xpath = "//input[@type='submit']") public WebElement loginButton;

    public void login () {
        Driver.getDriver().get(ConfigurationReader.getProperty("smart.bear"));
        username.sendKeys(getUserName());
        password.sendKeys(getPassword());
        loginButton.click();
    }

}
