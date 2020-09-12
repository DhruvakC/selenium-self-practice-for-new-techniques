package webPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class H_seventhPkgSignInThroughPOMFurnishedPage {

	public WebDriver driver;

	public H_seventhPkgSignInThroughPOMFurnishedPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// User Name locator
	@FindBy(name = "userName")
	public static WebElement userName;

	// Password locator
	@FindBy(name = "password")
	public static WebElement password;

	// Sign-In locator
	@FindBy(name = "submit")
	public static WebElement signin_btn;
	
	@FindBy(linkText = "Login Successfully")
	public static WebElement LoginSuccessful;

	public void browseWebsite(String websiteName) {
		driver.get("http://demo.guru99.com/test/newtours/index.php");
	}

	public void signIn(String userNameText, String passwordText) throws InterruptedException {

		userName.click();
		userName.sendKeys(userNameText);
		password.click();
		password.sendKeys(passwordText);
		signin_btn.click();
	}

	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	/*
	 * public void verifyLoginSuccess() {
	 * Assert.assertTrue(loginSuccessMessage.size()>0,
	 * "Login Successful message did not found"); }
	 */
	public List<WebElement> verifyLoginSuccess(){
		List<WebElement> loginSuccessMessage = driver.findElements(By.xpath("//h3[contains(text(),'Login Successfully')]"));		
		return loginSuccessMessage;
	}
}
