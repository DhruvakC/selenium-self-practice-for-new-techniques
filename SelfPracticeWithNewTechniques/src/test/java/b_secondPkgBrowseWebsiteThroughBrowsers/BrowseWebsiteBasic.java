package b_secondPkgBrowseWebsiteThroughBrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/*
 * @author Dhruvak Chokshi
 * Creation Date Sept 20
 * Purpose: Just a plain program to open chrome and firefox browser and then close it.
 */

public class BrowseWebsiteBasic {

	String chromeDriverLocation = "C:\\Selenium\\WorkSpace1\\MavenPomTestNG\\src\\main\\resources\\Drivers\\chromedriver.exe";
	String ffDriverLocation = "C:\\Selenium\\WorkSpace1\\MavenPomTestNG\\src\\main\\resources\\Drivers\\geckodriver.exe";

	@Test
	public void openChromeBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
		WebDriver chdr = new ChromeDriver();
		chdr.get("http://demo.guru99.com/test/newtours/index.php");
		Thread.sleep(3000);
		chdr.quit();
	}

	@Test
	public void openFireFoxBrowser() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", ffDriverLocation);
		WebDriver ffdr = new FirefoxDriver();
		ffdr.get("http://demo.guru99.com/test/newtours/index.php");
		Thread.sleep(3000);
		ffdr.quit();
	}

}
