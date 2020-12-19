package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.HomePage;
import pages.InboxPage;

public class BaseTest {

	WebDriver driver;
	HomePage homePage;
	InboxPage inbox;

	@BeforeMethod(alwaysRun = true)
	public void setup() {

		//Define and initialize WebDriver
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		// maximize the browser window
		driver.manage().window().maximize();
		//initialize page class objects
		homePage = new HomePage(driver);
		inbox = new InboxPage(driver);
	}

	@AfterMethod
	public void closeMethod(){
		driver.quit();
	}

}