package h_seventhPkgSignInPageVerificationThroughPOMFurnished;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import webPages.H_seventhPkgSignInThroughPOMFurnishedPage;

/*
 * @author Dhruvak Chokshi
 * Creation Date Sept 20
 * Purpose: In this program we have started using POM structure. Here, we are clicking sign In button
 * 			post providing username and password. It also shows how we can control browsers.
 * 			 
 */

public class SignInThroughPOMFurnished {

	String projectPath = System.getProperty("user.dir");

	@Test
	public void signInVerification() throws IOException, InterruptedException {

		WebDriver driver;
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(projectPath + "\\src\\main\\java\\dataFiles\\Config.Properties");
		prop.load(fis);
		
		if (prop.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if(prop.getProperty("Browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}


		H_seventhPkgSignInThroughPOMFurnishedPage signInObj = new H_seventhPkgSignInThroughPOMFurnishedPage(driver);
		signInObj.browseWebsite(prop.getProperty("URL"));
		signInObj.signIn(prop.getProperty("User"),prop.getProperty("Password"));
	
		List<WebElement> loginSuccessMessage = signInObj.verifyLoginSuccess();
		Assert.assertTrue(loginSuccessMessage.size()>0, "Login Successful message did not found");
		
		signInObj.closeBrowser();
	}

}
