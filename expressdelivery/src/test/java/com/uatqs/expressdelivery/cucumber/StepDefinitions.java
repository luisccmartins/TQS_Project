package com.uatqs.expressdelivery.cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class StepDefinitions {

    private WebDriver webDriver;
    
    @When("I navigate to {string}")
    public void i_navigate_to(String url) {
        webDriver = WebDriverManager.chromedriver().create();
        webDriver.get(url);
    }
    @When("I click on the Login button")
    public void i_click_on_the_login_button() {
        // Write code here that turns the phrase above into concrete actions
    }
    @When("I set the Email as {string}")
    public void i_set_the_email_as(String string) {
        // Write code here that turns the phrase above into concrete actions
    }
    @When("I set the Password as {string}")
    public void i_set_the_password_as(String string) {
        // Write code here that turns the phrase above into concrete actions
    }
    @When("I click on the {string} button")
    public void i_click_on_the_button(String string) {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("I click on the {string} button on the side bar")
    public void i_click_on_the_button_on_the_side_bar(String string) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("I should see the message {string}")
    public void i_should_see_the_message(String string) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("I should see a table with the names of the riders, such as {string}")
    public void i_should_see_a_table_with_the_names_of_the_riders_such_as(String string) {
        // Write code here that turns the phrase above into concrete actions
    }

    @After()
    public void closeBrowser() {
        webDriver.quit();
    }
}
