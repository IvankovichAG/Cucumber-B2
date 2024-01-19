package com.loop.pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SmartBearOrderPage extends SmartBearBasePage {

    @FindBy (xpath = "//select[contains(@name,'Product')]")
    public WebElement selectProduct;
    @FindBy(xpath = "//input[contains(@name,'Quantity')]")
    public WebElement enterQuantity;
    @FindBy(xpath = "//input[contains(@name,'Name')]")
    public WebElement customerName;
    @FindBy(xpath = "//input[contains(@name,'TextBox2')]")
    public WebElement street;
    @FindBy(xpath = "//input[contains(@name,'TextBox3')]")
    public WebElement city;
    @FindBy(xpath = "//input[contains(@name,'TextBox4')]")
    public WebElement state;
    @FindBy(xpath = "//input[contains(@name,'TextBox5')]")
    public WebElement zip;
    @FindBy (xpath = "//label[contains(.,'Express')]")
    public WebElement cardTypeAE;
    @FindBy(xpath = "//input[contains(@name,'TextBox6')]")
    public WebElement cardNumber;
    @FindBy(xpath = "//input[contains(@id,'TextBox1')]")
    public WebElement cardDate;
    @FindBy(xpath = "//a[contains(@id,'InsertButton')]")
    public WebElement processButton;
    public void chooseCard (String cardType){
        WebElement card = Driver.getDriver().findElement(By.xpath("//label[contains(.,'" + cardType + "')]"));
        card.click();
    }



}
