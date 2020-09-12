package n_pkgBrowserStackIntegrationWithSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class BrowserStackIntegrationWithSelenium {
  public static final String USERNAME = "dhruvak1";
  public static final String AUTOMATE_KEY = "SbQJqgBFZ16pDYVmN6Gx";
  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
  public static void main(String[] args) throws Exception {
    DesiredCapabilities caps = new DesiredCapabilities();
    
    caps.setCapability("browserName", "iPhone");
    caps.setCapability("device", "iPhone XS");
    caps.setCapability("realMobile", "true");
    caps.setCapability("os_version", "13");
    
    caps.setCapability("name", "dhruvak1's First Test with BrowserStack");
    
    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
    driver.get("http://www.google.com");
    WebElement element = driver.findElement(By.name("q"));

    element.sendKeys("BrowserStack");
    element.submit();
    Thread.sleep(3000);
    System.out.println(driver.getTitle());
    driver.quit();
  }
}