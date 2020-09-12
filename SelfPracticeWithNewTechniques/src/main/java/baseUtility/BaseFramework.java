package baseUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseFramework {
	public WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Properties prop = new Properties();

	public void setBase() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(projectPath + "\\src\\main\\java\\dataFiles\\Config.Properties");
		prop.load(fis);

		if (prop.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (prop.getProperty("Browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));

	}

	public void openBrowser() throws InterruptedException {

	}

	public void closeBrowser() {
		driver.close();
		driver.quit();
	}
}
