package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    public void clickOnElement(By element) {
        driver.findElement(element).click();
    }

    public void waitForElementToBeClickable(By element) {

        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeVisible(By element) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void sendTextToElement(By element, String text) {
        driver.findElement(element).sendKeys(text);
    }
}
