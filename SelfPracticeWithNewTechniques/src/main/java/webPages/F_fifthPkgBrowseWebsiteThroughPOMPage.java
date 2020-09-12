package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class F_fifthPkgBrowseWebsiteThroughPOMPage {

	public WebDriver driver;

	public F_fifthPkgBrowseWebsiteThroughPOMPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * //User Name locator
	 * 
	 * @FindBy(name = "userName") public static WebElement userName;
	 * 
	 * //Password locator
	 * 
	 * @FindBy(name = "password") public static WebElement password;
	 * 
	 * //Sign-In locator
	 * 
	 * @FindBy(name = "login") public static WebElement signin_btn;
	 */
	public void browseWebsite() throws InterruptedException {
		driver.get("http://demo.guru99.com/test/newtours/index.php");
		Thread.sleep(3000);
		driver.quit();
	}
}
