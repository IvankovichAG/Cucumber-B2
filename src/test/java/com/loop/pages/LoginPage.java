package com.loop.pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage () {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//input[@id='input-14']")
    public WebElement usernameInput;

    @FindBy (xpath = "//input[@id='input-15']")
    public WebElement passwordInput;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy (xpath = "//button[@type='submit']/span")
    public WebElement submitButton;

    @FindBy (xpath = "//span[.='Batch1 Group1']")
    public WebElement logoutBatch;

    @FindBy (xpath = "//span[.='Log out']")
    public WebElement logOutButton;










}
