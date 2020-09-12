package e_fifthPkgBrowseWebsiteSignInPageVerification;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

/*
 * @author Dhruvak Chokshi
 * Creation Date Sept 20
 * Purpose: In this program we enter username, password on a sign in page and verify that user login 
 * 			successful message is being appeared on page or not
 */

public class SignInPageVerification {

	/*
	 * Here we move Driver location to generic path. Benefit of this is if we send
	 * out this project to anyother user or anyother PC, it wil run without any
	 * setup as user.dir is inbuilt value
	 */
	String projectPath = System.getProperty("user.dir");
	String chromeDriverLocation = projectPath + "\\src\\main\\resources\\Drivers\\chromedriver.exe";
	String ffDriverLocation = projectPath + "\\src\\main\\resources\\Drivers\\geckodriver.exe";

	@Test
	public void openBrowser() throws IOException, InterruptedException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(projectPath + "\\src\\main\\java\\dataFiles\\Config.Properties");
		prop.load(fis);

		if (prop.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			/* System.setProperty("webdriver.chrome.driver", chromeDriverLocation); */
			
			WebDriverManager.chromedriver().setup();
			WebDriver chdr = new ChromeDriver();
			
			chdr.get("http://demo.guru99.com/test/newtours/index.php");
			chdr.findElement(By.xpath("//input[@name='userName']")).click();
			chdr.findElement(By.xpath("//input[@name='userName']")).sendKeys(prop.getProperty("User"));
			chdr.findElement(By.xpath("//input[@name='password']")).click();
			chdr.findElement(By.xpath("//input[@name='password']")).sendKeys(prop.getProperty("Password"));
			chdr.findElement(By.xpath("//input[@name='submit']")).click();
			
			List<WebElement> loginSuccessMessage = chdr.findElements(By.xpath("//h3[contains(text(),'Login Successfully')]"));
			Assert.assertTrue(loginSuccessMessage.size()>0, "Login Successful message did not found");
			
			Thread.sleep(3000);
			chdr.quit();
			
		} else if (prop.getProperty("Browser").equalsIgnoreCase("Firefox")) {
			//System.setProperty("webdriver.gecko.driver", ffDriverLocation);
			WebDriverManager.firefoxdriver().setup();
			WebDriver ffdr = new FirefoxDriver();
			ffdr.get("http://demo.guru99.com/test/newtours/index.php");
			Thread.sleep(3000);
			ffdr.quit();
		
		} else {
			System.out.println("This is not a valid option of browser. Kindly check Spelling under properties file.");
		}

	}

}
