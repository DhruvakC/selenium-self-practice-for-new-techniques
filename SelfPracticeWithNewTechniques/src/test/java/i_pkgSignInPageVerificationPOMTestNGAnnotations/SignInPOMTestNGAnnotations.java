package i_pkgSignInPageVerificationPOMTestNGAnnotations;

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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseUtility.BaseFramework;
import io.github.bonigarcia.wdm.WebDriverManager;
import webPages.H_seventhPkgSignInThroughPOMFurnishedPage;
import webPages.I_pkgSignInPageVerificationPOMTestNGAnnotations;

/*
 * @author Dhruvak Chokshi
 * Creation Date Sept 20
 * Purpose: In this program we have started using POM structure. Here, we are clicking sign In button
 * 			post providing username and password. It also shows how we can control browsers.
 * 			We have also moved basic methods to BaseFramework now.
 */

public class SignInPOMTestNGAnnotations extends BaseFramework {

	String projectPath = System.getProperty("user.dir");

	@BeforeMethod
	public void startWithTestCase() throws IOException {
		setBase();
	}

	@Test
	public void signInVerification() throws IOException, InterruptedException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(projectPath + "\\src\\main\\java\\dataFiles\\Config.Properties");
		prop.load(fis);

		I_pkgSignInPageVerificationPOMTestNGAnnotations signInObj = new I_pkgSignInPageVerificationPOMTestNGAnnotations(
				driver);
		signInObj.signIn(prop.getProperty("User"), prop.getProperty("Password"));

		List<WebElement> loginSuccessMessage = signInObj.verifyLoginSuccess();
		Assert.assertTrue(loginSuccessMessage.size() > 0, "Login Successful message did not found");

	}

	@AfterMethod
	public void endWithTestCase() {
		closeBrowser();
	}

}
