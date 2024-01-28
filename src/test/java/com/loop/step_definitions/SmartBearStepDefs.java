package com.loop.step_definitions;

import com.loop.pages.SmartBearBasePage;
import com.loop.pages.SmartBearLoginPage;
import com.loop.pages.SmartBearOrderPage;
import com.loop.utilities.BrowserUtils;
import com.loop.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class SmartBearStepDefs {
    SmartBearBasePage smartBearBasePage = new SmartBearBasePage();
    SmartBearLoginPage smartBearLoginPage = new SmartBearLoginPage();
    SmartBearOrderPage smartBearOrderPage = new SmartBearOrderPage();
    Select select;
    @Given("user is already logged in and navigated to order page")
    public void user_is_already_logged_in_and_navigated_to_order_page() {
        smartBearLoginPage.login();
        BrowserUtils.takeScreenshot();
        smartBearBasePage.orderButton.click();}
    @When("user selects product type {string}")
    public void user_selects_product_type(String productType) {
    select = new Select(smartBearOrderPage.selectProduct);
    select.selectByVisibleText(productType);}
    @When("user enters quantity {int}")
    public void user_enters_quantity(Integer quantity) {
        smartBearOrderPage.enterQuantity.sendKeys(String.valueOf(quantity));}
    @When("user enters customer name {string}")
    public void user_enters_customer_name(String customerName) {
        smartBearOrderPage.customerName.sendKeys(customerName);}
    @When("user enters street {string}")
    public void user_enters_street(String addressStreet) {
        smartBearOrderPage.street.sendKeys(addressStreet);
    }
    @When("user enters city {string}")
    public void user_enters_city(String addressCity) {
        smartBearOrderPage.city.sendKeys(addressCity);
    }
    @When("user enters state {string}")
    public void user_enters_state(String addressState) {
        smartBearOrderPage.state.sendKeys(addressState);
    }
    @When("user enters zip {string}")
    public void user_enters_zip(String addressZip) {
       smartBearOrderPage.zip.sendKeys(addressZip);}
    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String cardType) {

    smartBearOrderPage.chooseCard(cardType);


    }
    @When("user enters credit car number {string}")
    public void user_enters_credit_car_number(String ccNumber) {
        smartBearOrderPage.cardNumber.sendKeys(ccNumber);
    }
    @When("user enters expiration date {string}")
    public void user_enters_expiration_date(String expDate) {
        smartBearOrderPage.cardDate.sendKeys(expDate);
    }
    @When("user enters process order button")
    public void user_enters_process_order_button() {
        smartBearOrderPage.processButton.click();
    }
    @Then("user should see {string} in the first row of the table")
    public void user_should_see_in_the_first_row_of_the_table(String name) {
        smartBearBasePage.allOrdersButton.click();
        Assert.assertEquals(Driver.getDriver().findElement(By.xpath("//tr[2]/td[.='" + name + "'][1]")).getText(), name);
        BrowserUtils.takeScreenshot();

    }


}
