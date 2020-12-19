package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InboxPage extends BasePage {

    public InboxPage(WebDriver driver) {
        super(driver);
    }

    String emailBySubject = "//tr[@ng-repeat='email in emails']//a[contains(text(),'%s')]";
    By emailItem = By.xpath("//tr[@ng-repeat='email in emails']");
    By searchAccountField = By.id("inbox_field");
    By goBtn = By.id("go_inbox");
    By emptyInboxImg = By.id("publicm8rguy");

    public boolean findEmailBySubject(String subj){
        waitForElementToBeVisible(emailItem);
        int elementCount = driver.findElements(By.xpath(String.format(emailBySubject,subj))).size();
        return elementCount > 0;
    }

    public void inputSearchEmail(String input){
        waitForElementToBeClickable(searchAccountField);
        sendTextToElement(searchAccountField,input);
    }

    public void clickGoBtn(){
        waitForElementToBeClickable(goBtn);
        clickOnElement(goBtn);
    }

    public void waitForEmptyInboxLoaded(){
        waitForElementToBeVisible(emptyInboxImg);
    }

}



