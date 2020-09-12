package f_fifthPkgBrowseWebsiteThroughPOM;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import webPages.F_fifthPkgBrowseWebsiteThroughPOMPage;

/*
 * @author Dhruvak Chokshi
 * Creation Date Sept 20
 * Purpose: In this program we have started using POM structure. Associated src/main/java file is F_fifthPkgBrowseWebsiteThroughPOMPage.
 */

public class BrowseWebsiteThroughPOM {

	String projectPath = System.getProperty("user.dir");
	String chromeDriverLocation = projectPath + "\\src\\main\\resources\\Drivers\\chromedriver.exe";
	String ffDriverLocation = projectPath + "\\src\\main\\resources\\Drivers\\geckodriver.exe";
	// public WebDriver driver;

	@Test
	public void browseWebsite() throws IOException, InterruptedException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(projectPath + "\\src\\main\\java\\dataFiles\\Config.Properties");
		prop.load(fis);

		WebDriverManager.chromedriver().setup();
		WebDriver chdr = new ChromeDriver();

		F_fifthPkgBrowseWebsiteThroughPOMPage browseWebsiteObj = new F_fifthPkgBrowseWebsiteThroughPOMPage(chdr);
		browseWebsiteObj.browseWebsite();

	}

}
