package com.loop.pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartBearBasePage {
    public SmartBearBasePage () {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    private String userName = "Tester";
    private String password = "test";
    public String getUserName() {
        return userName;}
    public String getPassword() {
        return password;}
    @FindBy (xpath = "//a[contains(.,'Order')]")
    public WebElement orderButton;
    @FindBy (xpath = "//a[contains(.,'products')]")
    public WebElement allProductsButton;
    @FindBy (xpath = "//a[contains(.,'View all orders')]")
    public WebElement allOrdersButton;


}
