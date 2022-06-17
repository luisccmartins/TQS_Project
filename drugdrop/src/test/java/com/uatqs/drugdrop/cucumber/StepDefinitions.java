package com.uatqs.drugdrop.cucumber;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.uatqs.drugdrop.repository.UserRepository;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinitions {

    private static WebDriver driver;
    private final UserRepository userRepository;

    public StepDefinitions(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @When("I navigate to {string}")
    public void i_navigate_to(String url) {
        driver = new HtmlUnitDriver();
        driver.get(url);
        driver.manage().window().setSize(new Dimension(1512, 886));
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
    public void i_click_on_the_Loginbutton(String string) {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("I head to the {string} box")
    public void i_head_to_the_box(String string) {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("I select {string} as the quantity")
    public void i_select_as_the_quantity(String string) {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("I clck on the {string} button")
    public void i_clck_on_the_button(String string) {
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("I click on the {string} button to finalize the order")
    public void i_click_on_the_MakeOrderbutton(String string) {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("I set the Name as {string}")
    public void i_set_the_name_as(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I set the Address as {string}")
    public void i_set_the_address_as(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I am redirected to {string} to Login")
    public void i_am_redirected_to_to_login(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I should see my name {string} on the side bar")
    public void i_should_see_my_name_on_the_side_bar(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I set the Drugs's Name as {string}")
    public void i_set_the_drugs_s_name_as(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I set the Drug's Description as {string}")
    public void i_set_the_drug_s_description_as(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I set the Drug's Price as {string}")
    public void i_set_the_drug_s_price_as(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I should see {string} on the table of the provided drugs")
    public void i_should_see_on_the_table_of_the_provided_drugs(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



}
