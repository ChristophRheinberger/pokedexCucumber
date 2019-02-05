import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.PendingException;
import gherkin.formatter.model.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;


public class StepDef {

    private WebDriver driver;

    /**
     * Setup the firefox test driver. This needs the environment variable
     * 'webdriver.gecko.driver' with the path to the geckodriver binary
     */
    @Before
    public void before(Scenario scenario) throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platform", "WIN10");
        capabilities.setCapability("version", "64");
        capabilities.setCapability("browserName", "firefox");
        capabilities.setCapability("name", scenario.getName());

        if (!scenario.getName().endsWith("(video)")) {
            capabilities.setCapability("headless", true);
        }

        driver = new RemoteWebDriver(
                new URL("http://" + System.getenv("TESTINGBOT_CREDENTIALS") + "@hub.testingbot.com/wd/hub"),
                capabilities);

        // prevent errors if we start from a sleeping heroku instance
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void after() {
        driver.quit();
    }

    @Given("^Open (.*?)$")
    public void openHttpsFhvApplicationStagingHerokuappCom(String url) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.navigate().to(url);
    }

    @Given("Sample feature file is ready")
    public void givenStatement() {
            // Write code here that turns the phrase above into concrete actions
        System.out.println("Given Statement executed successfully!");
    }
    @When("I run the feature file")
    public void whenStatement () {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("When Statement executed successfully!");
    }
    @Then("Run should be successful")
    public void thenStatement () {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Then Statement executed successfully!");
    }
}