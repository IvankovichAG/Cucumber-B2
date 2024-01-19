package com.loop.step_definitions;

import com.loop.pages.LoginPage;
import com.loop.utilities.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();
    @Given("user is on Docuport login page")
    public void user_is_on_docuport_login_page() {Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    BrowserUtils.takeScreenshot();}
    @When("user enters username for client")
    public void user_enters_username_for_client() {
        BrowserUtils.waitForClickable(loginPage.loginButton, DocuportConstants.large);
        loginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_CLIENT);}
    @When("user enters password for client")
    public void user_enters_password_for_client() {
        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD);}
    @When("user clicks login button")
    public void user_clicks_login_button() {
        loginPage.loginButton.click();}
    @Then("user should see the home page for client")
    public void user_should_see_the_home_page_for_client() {
//        BrowserUtils.waitForClickable(loginPage.submitButton, DocuportConstants.extraLarge);
//        loginPage.submitButton.click();
        assertTrue(Driver.getDriver().getCurrentUrl().equals(DocuportConstants.DOCUPORT_URL));
    BrowserUtils.takeScreenshot();}
    @Then("user clicks logout button")
    public void user_clicks_logout_button() {
        loginPage.logoutBatch.click();
        loginPage.logOutButton.click();}
    @Then("user should see login page")
    public void user_should_see_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));}
    @When("user enters username for employee")
    public void user_enters_username_for_employee() {
        BrowserUtils.waitForClickable(loginPage.loginButton, DocuportConstants.large);
        loginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_EMPLOYEE);}
    @When("user enters password for employee")
    public void user_enters_password_for_employee() {
        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD);}
    @Then("user should see the home page for employee")
    public void user_should_see_the_home_page_for_employee() {
        BrowserUtils.waitForVisibility(loginPage.logoutBatch, DocuportConstants.large);
        assertTrue(Driver.getDriver().getCurrentUrl().equals(DocuportConstants.DOCUPORT_URL));}
    @When("user enters username for advisor")
    public void user_enters_username_for_advisor() {
        loginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_ADVISOR);}
    @When("user enters password for advisor")
    public void user_enters_password_for_advisor() {
        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD);}
    @Then("user should see the home page for advisor")
    public void user_should_see_the_home_page_for_advisor() {
        BrowserUtils.waitForVisibility(loginPage.logoutBatch, DocuportConstants.large);
        assertTrue(Driver.getDriver().getCurrentUrl().equals(DocuportConstants.DOCUPORT_URL));}
    @When("user enters username for supervisor")
    public void user_enters_username_for_supervisor() {
        BrowserUtils.waitForClickable(loginPage.loginButton, DocuportConstants.large);
        loginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_SUPERVISOR);}
    @When("user enters password for supervisor")
    public void user_enters_password_for_supervisor() {
        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD);}
    @Then("user should see the home page for supervisor")
    public void user_should_see_the_home_page_for_supervisor() {
        BrowserUtils.waitForVisibility(loginPage.logoutBatch, DocuportConstants.large);
        assertTrue(Driver.getDriver().getCurrentUrl().equals(DocuportConstants.DOCUPORT_URL));}


    @When("user enters credentials")
    public void user_enters_credentials(Map<String, String> credentials) {
//
//        for (Map.Entry<String, String > entry : credentials.entrySet()) {
//            String key = entry.getKey();
//            System.out.println("key " + key);
//            String value = entry.getValue();
//            System.out.println("value " + value);
//        }
//    }
        loginPage.loginDocuport(credentials.get("username"), credentials.get("password"));

    }
}
