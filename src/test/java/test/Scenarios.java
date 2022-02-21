package test;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        calcPage = new FactoringCalculatorPage(driver);
        popup = new CookiesPopup(driver);
        log.info("Starting Factoring calculator test application");
    }

    @Given("As a Swedbank user I open Factoring Calculator page and close the Cookies popup")
    public void navigateToTheCalculatorPage() throws InterruptedException {
        log.info("Factoring calculator: " + calcPage.getURL() + " page is opening");
        driver.get(calcPage.getURL());
        driver.manage().window().maximize();
        log.info("Cookies popup is closing");
        popup.closePopup();
        Thread.sleep(10000);
    }

    @Given("Calculate button is displayed")
    public void calculateButtonIsPresent(){
        log.info("Checking calculate button presence");
        assertThat(calcPage.checkCalculateButton()).isTrue();
    }

    @And("input {string} invoice amount")
    public void inputInvoiceAmount(String invoiceAmount) throws InterruptedException {
        log.info("Clear default values");
        calcPage.clearInvoiceAmountField();
        log.info("User inputs " + invoiceAmount + " invoice amount");
        calcPage.setInvoiceAmountField(invoiceAmount);
        Thread.sleep(10000);
    }

    @And("input {string} interest rate")
    public void inputInterestRate(String interestRate) {
        log.info("Clear default values");
        calcPage.clearInterestRate();
        log.info("User inputs " + interestRate + " interest rate");
        calcPage.setInterestRate(interestRate);
    }

    @And("input {string} commission fee")
    public void inputCommissionFee(String commissionFee) {
        log.info("Clear default values");
        calcPage.clearCommissionFee();
        log.info("User inputs " + commissionFee + " commission fee");
        calcPage.setCommissionFee(commissionFee);
    }

    @And("select {int} advance rate")
    public void selectAdvanceRate(int advanceRate) {
        log.info("User selects " + advanceRate + " advance rate");
        calcPage.selectAdvanceRate(advanceRate);
    }

    @And("select {int} payment term")
    public void selectPaymentTerms(int paymentTerm) {
        log.info("User selects " + paymentTerm + " payment term");
        calcPage.selectPaymentTerm(paymentTerm);
    }

    @When("click on the Calculate button")
    public void clickOnCalculateButton() {
        calcPage.clickCalculateButton();
    }

    @Then("{string} percent and {string} values are calculated")
    public void checkCalculatedValues(String expectedPercentResult, String expectedResult) {
        assertThat(calcPage.getCalculatorResultPercent()).isEqualTo(expectedPercentResult);
        assertThat(calcPage.getCalculatorResult()).isEqualTo(expectedResult);
    }

    @Then("{string} validation message is displayed")
    public void checkValidationMessage(String expectedValidationMessage) {
        assertThat(calcPage.getValidationMessage()).isEqualTo(expectedValidationMessage);
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
