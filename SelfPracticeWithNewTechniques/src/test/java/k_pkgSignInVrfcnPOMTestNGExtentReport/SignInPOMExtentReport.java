package k_pkgSignInVrfcnPOMTestNGExtentReport;

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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import baseUtility.BaseFramework;

import webPages.I_pkgSignInPageVerificationPOMTestNGAnnotations;

/*
 * @author Dhruvak Chokshi
 * Creation Date Sept 20
 * Purpose: First you need to install extent report maven dependency
 * 			Somehow 5.0 and all are not working by any means so, I used 3.1.5
 * 			Go to https://extentreports.com/docs/versions/3/java/#basic-usage site
 * 			Here, I have just shown log, info just for a reference that we can use extent report like this.
 */

public class SignInPOMExtentReport extends BaseFramework {

	String projectPath = System.getProperty("user.dir");
	Logger log = Logger.getLogger(SignInPOMExtentReport.class);
	//ExtentTest test = extent.createTest("MyFirstTest", "Simplediscription");
	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
	ExtentReports extent = new ExtentReports();
	
	

	@BeforeMethod
	public void startWithTestCase() throws IOException {
		 log.info("==========Browser opening process started=======");

		extent.attachReporter(htmlReporter);
		ExtentTest extentLogger = extent.createTest("startWithTestCase");	
		extentLogger.log(Status.INFO, "EXTENT REPORT LOG: This step shows that browser opening is completed successfully.");
		
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

		ExtentTest extentLogger = extent.createTest("startWithTestCase");	
		extentLogger.info("EXTENT REPORT LOG: This step shows buttons click is completed successfully.");
		extentLogger.fail("EXTENT REPORT LOG: This step shows fail log. we can put it in try catch blog.");
		//

		List<WebElement> loginSuccessMessage = signInObj.verifyLoginSuccess();
		Assert.assertTrue(loginSuccessMessage.size() > 0, "Login Successful message did not found");
		extentLogger.addScreenCaptureFromPath("C:\\Selenium\\WorkSpace1\\SelfPracticeWithNewTechniques\\src\\main\\resources\\Screenshots\\abc.jpg");
	}

	@AfterMethod
	public void endWithTestCase() {
		closeBrowser();
		extent.flush();
	}

}
