package ohtu;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Stepdefs {
    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";

    @Given("login is selected")
    public void loginIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();
    }

    @Given("command new user is selected")
    public void newIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.xpath("//a[@href='user']"));
        element.click();
    }

    @When("a valid username {string} and password {string} and matching password confirmation are entered")
    public void validNewUsernameAndPasswordAreGiven(String username, String password) {
        newUserWith(username, password, password);
    }

    @When("an invalid username {string} and a valid password {string} and matching password confirmation are entered")
    public void invalidNewUsernameAndValidPasswordAreGiven(String username, String password) {
        newUserWith(username, password, password);
    }

    @When("a valid username {string} and an invalid password {string} and matching password confirmation are entered")
    public void validNewUsernameAndInvalidPasswordAreGiven(String username, String password) {
        newUserWith(username, password, password);
    }

    @When("a valid username {string} and a valid password {string} and a nonmatching password {string} confirmation are entered")
    public void validNewUsernameAndInvalidPasswordAreGivenNonmatch(String username, String password, String password2) {
        newUserWith(username, password, password2);
    }

    @When("correct username {string} and password {string} are given")
    public void correctUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }

    @Then("user is logged in")
    public void userIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    }

    @Then("a new user is created")
    public void userIsSignedUp() {
        pageHasContent("Welcome to Ohtu Application!");
    }

    @When("nonexistent username {string} and a password {string} are given")
    public void nonexistentUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }

    @When("correct username {string} and incorrect password {string} are given")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }

    @Then("user is not logged in and error message is given")
    public void userIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }

    @Then("user is not created and error {string} is reported")
    public void userIsNotSignedUpAndErrorMessageIsGiven(String error) {
        pageHasContent(error);
    }

    @Then("system will respond {string}")
    public void systemWillRespond(String pageContent) throws Throwable {
        assertTrue(driver.getPageSource().contains(pageContent));
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    /* helper methods */

    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }

    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();
    }

    private void newUserWith(String username, String password, String password2) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(password2);
        element = driver.findElement(By.name("signup"));
        element.submit();
    }
}
