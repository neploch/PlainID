package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    String mailinatorUrl = "https://www.mailinator.com/";

    By searchTextField = By.id("addOverlay");
    By searchGoBtn = By.id("go-to-public");
    By emailLink = By.xpath("//div[contains(@class,'wrapper-nav-items')]//a[@aria-label='Email']");

    public void getWebSite() {
        driver.get(mailinatorUrl);
    }

    public void inputSearchEmail(String input) {
        waitForElementToBeClickable(searchTextField);
        sendTextToElement(searchTextField, input);
    }

    public void clickGoBtn() {
        waitForElementToBeClickable(searchGoBtn);
        clickOnElement(searchGoBtn);
    }

    public void clickEmailLink() {
        waitForElementToBeClickable(emailLink);
        clickOnElement(emailLink);
    }
}
