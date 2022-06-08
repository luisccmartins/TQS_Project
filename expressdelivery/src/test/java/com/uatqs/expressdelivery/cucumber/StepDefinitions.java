package com.uatqs.expressdelivery.cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;

import static org.hamcrest.CoreMatchers.containsString;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;

public class StepDefinitions {

    private WebDriver webDriver;
    
    @When("I navigate to {string}")
    public void i_navigate_to(String url) {
        webDriver = new HtmlUnitDriver();
        webDriver.get(url);
    }
    @When("I set the Email as {string}")
    public void i_set_the_email_as(String email) {
        webDriver.findElement(By.xpath("/html/body/div/form/div[2]/input[1]")).sendKeys(email);
    }
    @When("I set the Password as {string}")
    public void i_set_the_password_as(String password) {
        webDriver.findElement(By.id("password")).sendKeys(password);
    }
    @When("I click on the {string} button")
    public void i_click_on_the_button(String login) {
        webDriver.findElement(By.id("loginSubmit")).click();
    }

    @When("I click on the {string} button on the side bar")
    public void i_click_on_the_button_on_the_side_bar(String dashboard) {
        webDriver.findElement(By.linkText("Riders Performance")).click();
    }

    @Then("I should see the message {string}")
    public void i_should_see_the_message(String string) {
        assertThat(webDriver.findElement(By.xpath(".//div[@class='navbar-menu-wrapper d-flex align-items-center']/form[@class='ml-auto search-form d-none d-md-block']/div[@class='form-group']")).getText(), containsString(string));
    }

    @Then("I should see a table with the names of the riders, such as {string}")
    public void i_should_see_a_table_with_the_names_of_the_riders_such_as(String rider) {
        assertThat(webDriver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[1]/div/div/div[2]/div[2]/span")).getText()).isEqualTo(rider);
    }

    @After()
    public void closeBrowser() {
        webDriver.quit();
    }
}
