package com.uatqs.drugdrop.cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.uatqs.drugdrop.repository.UserRepository;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StepDefinitionsAddService {
    
    private static WebDriver driver;

    @When("I navigate to register {string}")
    public void i_navigate_toAdmin(String url) {
        driver = new HtmlUnitDriver();
        driver.get(url);
        driver.manage().window().setSize(new Dimension(1900, 1000));
    }

    @When("I navigate to login {string}")
    public void i_navigate_toAdminLogin(String url) {
        driver = new HtmlUnitDriver();
        driver.get(url);
        driver.manage().window().setSize(new Dimension(1900, 1000));
    }

    @When("I set the Email as Admin {string}")
    public void i_set_the_email_asAdmin(String adminEmail) {
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(adminEmail);

    }
    @When("I set the Password as Admin {string}")
    public void i_set_the_password_asAdmin(String adminPassword) {
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(adminPassword);

    }

    @When("I set the Name as {string}")
    public void i_set_the_name_as(String storeName) {
        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).sendKeys(storeName);
    }
    @When("I set the Address as {string}")
    public void i_set_the_address_as(String address) {
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).sendKeys(address);
    }

    @When("I click on the register button")
    public void i_click_on_the_register_button() {
        driver.findElement(By.id("registerStore")).click();
    }

    @When("I am redirected to {string} to Login")
    public void i_am_redirected_to_to_login(String url) {
        driver.get(url);
    }

    @When("I set the Email as {string}")
    public void i_set_the_email_as(String string) {
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(string);
    }
    @When("I set the Password as {string}")
    public void i_set_the_password_as(String string) {
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(string);
    }

    @When("I click on the login button")
    public void i_click_on_the_Loginbutton() {
        driver.findElement(By.id("loginSubmit")).click();

    }

    @Then("I should see be redirected to {string}")
    public void i_should_see_be_redirected_to(String url) {
        driver.get(url);
    }

    @When("I click on the Login button")
    public void i_click_on_the_login_button() {
        driver.findElement(By.id("loginSubmit")).click();
    }

    @When("I should see be redirected back to {string}")
    public void i_should_see_be_redirected_toPage(String url) {
        driver.get(url);
    }

    @When("I click on the Add Drug button")
    public void i_click_on_the_add_drug_button() {
        driver.findElement(By.name("addDrug")).click();
    }

    @When("I set the Drugs's Name as {string}")
    public void i_set_the_drugs_s_name_as(String string) {
        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).sendKeys(string);
    }
    @When("I set the Drug's Description as {string}")
    public void i_set_the_drug_s_description_as(String string) {
        driver.findElement(By.name("description")).click();
        driver.findElement(By.name("description")).sendKeys(string);
    }
    @When("I set the Drug's Price as {string}")
    public void i_set_the_drug_s_price_as(String string) {
        driver.findElement(By.name("price")).click();
        driver.findElement(By.name("price")).sendKeys(string);
    }

    @When("I click on the Add New Drug button")
    public void i_click_on_the_addNew_drug_button() {
        driver.findElement(By.id("addDrug")).click();
    }

    @Then("I should see {string} on the table of the provided drugs")
    public void i_should_see_on_the_table_of_the_provided_drugs(String string) {
        driver.findElement(By.id("drugName")).getText();
    }
}
