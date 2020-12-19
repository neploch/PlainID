package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MainRunner extends BaseTest {

	//Test data
	final String emailSubjectTest1 = "Mail 2";
	final String emailSubjectTest2 = "Mail 3";
	final String name = "Eliyahu";
	final String emailBase = "@mailinator.com";
	final String emailPrefix1 = "732574";
	final String emailPrefix2 = "215475";
	final String email1 = name + emailPrefix1 + emailBase;
	final String email2 = name + emailPrefix2 + emailBase;
	
	@Test(priority = 1 ,groups= "Received emails validation", description= "Enter public email account inbox from Home page by Go button, search for email in the inbox by subject")
	public void goAndValidateEmailInInbox()
	{
		homePage.getWebSite();
		homePage.inputSearchEmail(email1);
		homePage.clickGoBtn();
		Assert.assertTrue(inbox.findEmailBySubject(emailSubjectTest1),String.format("Email with subject %s was not found in the %s inbox",emailSubjectTest1,email1));
	}

	@Test(priority = 2 ,groups= "Received emails validation", description= "Enter the inbox via Email button, insert user email, press inbox Go button, search for email by subject")
	public void emailAndValidateEmailInInbox()
	{
		homePage.getWebSite();
		homePage.clickEmailLink();
		inbox.waitForEmptyInboxLoaded();
		inbox.inputSearchEmail(email2);
		inbox.clickGoBtn();
		Assert.assertTrue(inbox.findEmailBySubject(emailSubjectTest2),String.format("Email with subject %s was not found in the %s inbox",emailSubjectTest2,email2));
	}
}
