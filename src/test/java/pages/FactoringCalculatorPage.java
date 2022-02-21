package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class FactoringCalculatorPage {
    WebDriver driver;
    private String FactoringCalculatorURL = "https://www.swedbank.lt/business/finance/trade/factoring?language=ENG";
    By invoiceAmountField = By.xpath("//*[@id=\"D5\"]");
    By advanceRateField75 = By.xpath("//*[@id=\"D6\"]/option[1]");
    By advanceRateField80 = By.xpath("//*[@id=\"D6\"]/option[2]");
    By advanceRateField85 = By.xpath("//*[@id=\"D6\"]/option[3]");
    By advanceRateField90 = By.xpath("//*[@id=\"D6\"]/option[4]");
    By interestRate = By.xpath("//*[@id=\"D7\"]");
    By paymentTerm30 = By.xpath("//*[@id=\"D8\"]/option[1]");
    By paymentTerm60 = By.xpath("//*[@id=\"D8\"]/option[2]");
    By paymentTerm90 = By.xpath("//*[@id=\"D8\"]/option[3]");
    By paymentTerm120 = By.xpath("//*[@id=\"D8\"]/option[4]");
    By commissionFee = By.xpath("//*[@id=\"D9\"]");
    By calculateButton = By.xpath("//*[@id=\"calculate-factoring\"]");
    By calculatorResultPercent = By.xpath("//*[@id=\"result_perc\"]");
    By calculatorResult = By.xpath("//*[@id=\"result\"]");
    By invoiceAmountValidationMessage =  By.cssSelector("#calc > dl > dd:nth-child(2) > div");



    public FactoringCalculatorPage(WebDriver driver) {
        this.driver=driver;
    }


    public String  getURL(){
        return this.FactoringCalculatorURL;
    }

    public void selectAdvanceRate(int advancedRate) {
        switch (advancedRate) {
            case 75:
                driver.findElement(advanceRateField75).click();
                break;
            case 80:
                driver.findElement(advanceRateField80).click();
                break;
            case 85:
                driver.findElement(advanceRateField85).click();
                break;
            case 90:
                driver.findElement(advanceRateField90).click();
                break;
        }
    }

    public boolean checkAdvanceRate(){
        return driver.findElement(advanceRateField75).isDisplayed()
                & driver.findElement(advanceRateField80).isDisplayed()
                & driver.findElement(advanceRateField85).isDisplayed()
                & driver.findElement(advanceRateField90).isDisplayed();
    }

    public void selectPaymentTerm(int paymentTerm) {
        switch (paymentTerm) {
            case 30:
                driver.findElement(paymentTerm30).click();
                break;
            case 60:
                driver.findElement(paymentTerm60).click();
                break;
            case 90:
                driver.findElement(paymentTerm90).click();
                break;
            case 120:
                driver.findElement(paymentTerm120).click();
                break;
        }
    }

    public boolean checkPaymentTerm(){
        return driver.findElement(paymentTerm30).isDisplayed()
                & driver.findElement(paymentTerm60).isDisplayed()
                & driver.findElement(paymentTerm90).isDisplayed()
                & driver.findElement(paymentTerm120).isDisplayed();
    }

    public void clearInvoiceAmountField(){
        driver.findElement(invoiceAmountField).clear();
    }


    public void setInvoiceAmountField(String invoiceAmountFieldValue){
        driver.findElement(invoiceAmountField).sendKeys(invoiceAmountFieldValue);
    }

    public boolean checkInvoiceAmountField(){
        return driver.findElement(invoiceAmountField).isDisplayed();
    }

    public void clearInterestRate(){
        driver.findElement(interestRate).clear();
    }

    public void setInterestRate(String interestRateValue){
        driver.findElement(interestRate).sendKeys(interestRateValue);
    }

    public boolean checkInterestRate(){
        return driver.findElement(interestRate).isDisplayed();
    }

    public void clearCommissionFee(){
        driver.findElement(commissionFee).clear();
    }

    public void setCommissionFee(String commissionFeeValue){
        driver.findElement(commissionFee).sendKeys(commissionFeeValue);
    }

    public boolean checkCommissionFee(){
        return driver.findElement(commissionFee).isDisplayed();
    }

    public void clickCalculateButton(){
        driver.findElement(calculateButton).click();
    }

    public boolean checkCalculateButton(){
        return driver.findElement(calculateButton).isDisplayed();
    }

    public String getCalculatorResultPercent(){
        return driver.findElement(calculatorResultPercent).getText();
    }

    public String getCalculatorResult(){
        return driver.findElement(calculatorResult).getText();
    }

    public String getValidationMessage(){
        return driver.findElement(invoiceAmountValidationMessage).getText();
    }

}
