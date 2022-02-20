package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CookiesPopup {

    WebDriver driver;

    public CookiesPopup(WebDriver driver) {
        this.driver = driver;
    }

    By popupWindow = By.xpath("//*[@id=\"cookie-consent\"]/ui-modal/div[2]/div/div[1]/div/button[3]");

    public void closePopup() {
        driver.findElement(popupWindow).click();
    }
}
