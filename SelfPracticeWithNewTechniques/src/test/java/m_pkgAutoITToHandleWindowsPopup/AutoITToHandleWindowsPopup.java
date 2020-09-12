package m_pkgAutoITToHandleWindowsPopup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * @author Dhruvak Chokshi
 * Creation Date Sept 20
 * Purpose: Just a plain program to open chrome and firefox browser and then close it.
 */

public class AutoITToHandleWindowsPopup {

	String projectPath = System.getProperty("user.dir");
	String chromeDriverLocation = projectPath + "\\src\\main\\resources\\Drivers\\chromedriver.exe";
	String ffDriverLocation = projectPath + "\\src\\main\\resources\\Drivers\\geckodriver.exe";

	@Test
	public void openChromeBrowser() throws InterruptedException, IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(projectPath + "\\src\\main\\java\\dataFiles\\Config.Properties");
		prop.load(fis);

		if (prop.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			//System.setProperty("webdriver.chrome.driver", chromeDriverLocation); 
			
			WebDriverManager.chromedriver().setup();
			WebDriver chdr = new ChromeDriver();
			
			//chdr.get("https://tus.io/demo.html");
			chdr.get("http://tinyupload.com");
			Thread.sleep(3000);
			chdr.findElement(By.name("uploaded_file")).click();
			//chdr.findElement(By.xpath("//input[@id='js-file-input']")).click();

			Thread.sleep(3000);
			Runtime.getRuntime().exec("FileUploadAutoIT.exe");
			Thread.sleep(3000);
			chdr.quit();
			
		} else if (prop.getProperty("Browser").equalsIgnoreCase("Firefox")) {
			//System.setProperty("webdriver.gecko.driver", ffDriverLocation);
			WebDriverManager.firefoxdriver().setup();
			WebDriver ffdr = new FirefoxDriver();
			ffdr.get("http://www.tinyupload.com/");
			Thread.sleep(3000);
			ffdr.quit();
		
		} else {
			System.out.println("This is not a valid option of browser. Kindly check Spelling under properties file.");
		}
	}
}
