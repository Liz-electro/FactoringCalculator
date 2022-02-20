import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CookiesPopup;
import pages.FactoringCalculatorPage;


import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class Scenarios {

    WebDriver driver;
    FactoringCalculatorPage calcPage;
    CookiesPopup popup;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        calcPage = new FactoringCalculatorPage(driver);
        popup = new CookiesPopup(driver);
        log.info("Starting Factoring calculator test application");
    }


    @Given("As a Swedbank user I open Factoring Calculator page and close the Cookies popup")
    public void userNavigatesToTheCalculatorPage() throws InterruptedException {
        log.info("Factoring calculator: " + calcPage.getURL() + " page is opening");
        driver.get(calcPage.getURL());
        driver.manage().window().maximize();
        log.info("Cookies popup is closing");
        popup.closePopup();
        //change to correct waiter
        Thread.sleep(10000);
    }


    @And("click on the Calculate button")
    public void clickOnCalculateButton() {
        calcPage.clickCalculateButton();
    }


    @Then("{string} percent and {string} values are calculated")
    public void checkCalculatedValues(String expectedPercentResult, String expectedResult) {
        assertThat(calcPage.getCalculatorResultPercent()).isEqualTo(expectedPercentResult);
        assertThat(calcPage.getCalculatorResult()).isEqualTo(expectedResult);
    }


    @After
    public void tearDown() {
        log.info("Closing application");
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
