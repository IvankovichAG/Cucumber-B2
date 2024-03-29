package com.loop.step_definitions;

import com.loop.pages.ProductPage;
import com.loop.utilities.BrowserUtils;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductStepDefs {
    ProductPage productPage = new ProductPage();

    @Given("User is on the HomePage")
    public void user_is_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("product.url"));
    }
    @Then("User should be able to see expected prices in following products")
    public void user_should_be_able_to_see_expected_prices_in_following_products(List<Map<String, String>> productDetails) throws InterruptedException {
        for(Map<String, String> productDetail : productDetails){
//            System.out.println("=============Product Detail===============");
//            System.out.println("productDetail.get(\"Category\") = " + productDetail.get("Category"));
//            System.out.println("productDetail.get(\"Product\") = " + productDetail.get("Product"));
//            System.out.println("productDetail.get(\"expectedPrice\") = " + productDetail.get("expectedPrice"));

            //click category
            productPage.clickCategory(productDetail.get("Category"));
            //
            String actualPrice = productPage.getProductPrice(productDetail.get("Product"));

            // to get product price
            String expectedPrice = productDetail.get("expectedPrice");

            Assert.assertEquals(expectedPrice, actualPrice);
        }
    }

    @Then("User should be able to see expected prices in following products with listOflist")
    public void user_should_be_able_to_see_expected_prices_in_following_products_with_list_oflist( List < List <String> > productDetails) throws InterruptedException {
        for (List<String> productDetail : productDetails) {

            // category
            productPage.clickCategory(productDetail.get(0));
            // actual price
            String actualPrice = productPage.getProductPrice(productDetail.get(1));

            String expectedPrice = productDetail.get(2);
            assertEquals(actualPrice, expectedPrice);


        }
    }


    @Then("User should be able to see the following names in their groups")
    public void user_should_be_able_to_see_the_following_names_in_their_groups(Map <String, List <String>> students) {
        List <String> group1 = students.get("Group1");
        System.out.println("group1 = " + group1);

        List <String> group2 = students.get("Group2");
        System.out.println("group2 = " + group2);

        List <String> group3 = students.get("Group3");
        System.out.println("group3 = " + group3);
    }

}