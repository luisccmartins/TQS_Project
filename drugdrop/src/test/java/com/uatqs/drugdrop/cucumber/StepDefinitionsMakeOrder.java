package com.uatqs.drugdrop.cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.uatqs.drugdrop.repository.UserRepository;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionsMakeOrder {

    private static WebDriver driver;
    private final UserRepository userRepository;

    public StepDefinitionsMakeOrder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @When("I navigate to {string}")
    public void i_navigate_to(String url) {
        driver = new HtmlUnitDriver();
        driver.get(url);
        driver.manage().window().setSize(new Dimension(1900, 1000));
    }
    @When("I set the Email as User {string}")
    public void i_set_the_email_as(String userEmail) {
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(userEmail);
    }
    @When("I set the Password as User {string}")
    public void i_set_the_password_as(String userPassword) {
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(userPassword);

    }
    @When("I click on the login user button")
    public void i_click_on_the_LoginbuttonOrder() {
        driver.findElement(By.id("loginSubmit")).click();

    }
    @When("I head to the {string} box")
    public void i_head_to_the_box(String string) {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("I click on the Add To Basket button")
    public void i_clck_on_the_button(String string) {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("I click on the Basket button")
    public void i_clck_on_the_Basketbutton(String string) {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("I click on the Make Order button to finalize the order")
    public void i_click_on_the_MakeOrderbutton(String string) {
        // Write code here that turns the phrase above into concrete actions

    }
}
