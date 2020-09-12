package j_pkgSignInVrfcnPOMTestNGLog4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import baseUtility.BaseFramework;

import webPages.I_pkgSignInPageVerificationPOMTestNGAnnotations;

/*
 * @author Dhruvak Chokshi
 * Creation Date Sept 20
 * Purpose: First you need to install log4j maven dependency.
 * 			Second if you do not add log4j.properties or log4j.xml then it will just show info.ERROR 
 * 					only on console and do not store it anywhere.
 * 					It will not even show log.info message on screen or in any file
 * 					That is why you need to enter log4j.properties or log4j.xml
 * 			Third install log4j.properties file from https://springframework.guru/log4j-2-configuration-using-properties-file/
 * 					Or we can use it from any other website.
 * 			Forth once the program will run it will show log on console as well as on log folder under log files.
 * 			 
 */

public class SignInPOMLog4j extends BaseFramework {

	String projectPath = System.getProperty("user.dir");
	Logger log = Logger.getLogger(SignInPOMLog4j.class);

	@BeforeMethod
	public void startWithTestCase() throws IOException {
		log.info("==========Browser opening process started=======");
		setBase();
	}

	@Test
	public void signInVerification() throws IOException, InterruptedException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(projectPath + "\\src\\main\\java\\dataFiles\\Config.Properties");
		prop.load(fis);

		log.info("==========Main logic started=======");
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
