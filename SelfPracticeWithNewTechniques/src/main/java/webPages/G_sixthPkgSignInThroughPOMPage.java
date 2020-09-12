package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class G_sixthPkgSignInThroughPOMPage {

	public WebDriver driver;

	public G_sixthPkgSignInThroughPOMPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	  //User Name locator 
	  @FindBy(name = "userName") 
	  public static WebElement userName;
	 
	  //Password locator
	  @FindBy(name = "password") 
	  public static WebElement password;
	  
	  //Sign-In locator
	  @FindBy(name = "submit") 
	  public static WebElement signin_btn;
	
	public void signIn(String userNameText,String passwordText) throws InterruptedException {

		driver.get("http://demo.guru99.com/test/newtours/index.php");

		userName.click();
		userName.sendKeys(userNameText);
		password.click();
		password.sendKeys(passwordText);
		signin_btn.click();	
		
		Thread.sleep(3000);
		driver.quit();
	}
}
