package l_pkgSampleTestThroughKatalonStudioEAsiteLogin;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SampleTCThroughKatalonRecorderEASiteLogin {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
   // driver = new FirefoxDriver();
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSampleTCThroughKatalonRecorderEASiteLogin() throws Exception {
    driver.get("https://help.ea.com/in/");
    Thread.sleep(3000);
    driver.findElement(By.xpath("//div[@id='gus']//a[@class='login'][contains(text(),'Log In')]")).click();
    //driver.findElement(By.linkText("Log In")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=1 | ]]
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("Admin12!@");
    driver.findElement(By.xpath("//html")).click();
    driver.findElement(By.xpath("//a[@id='btnLogin']/span")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | relative=parent | ]]
    driver.findElement(By.xpath("(//img[@alt='Choose the game you need help with'])[2]")).click();
    driver.findElement(By.xpath("(//input[@type='text'])[3]")).click();
    driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("FIFA");
    driver.findElement(By.xpath("//div[@id='selector']/div[2]/div[3]/ul/li[3]/a/span")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
