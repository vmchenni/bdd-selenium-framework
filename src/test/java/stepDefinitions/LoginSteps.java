package stepDefinitions;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pages.LoginPage;
import utils.DriverFactory;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;

    @Before
    public void setUp() {
        driver = DriverFactory.initDriver();
    }

    @Given("User launches the application")
    public void user_launches_the_application() {
        driver.get("https://example.com/login");
        loginPage = new LoginPage(driver);
    }

    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password() {
        loginPage.login("admin", "admin123");
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        String title = driver.getTitle();
        assert title.contains("Dashboard");
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
