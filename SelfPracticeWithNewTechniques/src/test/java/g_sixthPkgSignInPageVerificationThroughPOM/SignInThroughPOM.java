package g_sixthPkgSignInPageVerificationThroughPOM;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import webPages.F_fifthPkgBrowseWebsiteThroughPOMPage;
import webPages.G_sixthPkgSignInThroughPOMPage;

/*
 * @author Dhruvak Chokshi
 * Creation Date Sept 20
 * Purpose: In this program we have started using POM structure. Here, we are clicking 
 */

public class SignInThroughPOM {

	String projectPath = System.getProperty("user.dir");

	@Test
	public void browseWebsite() throws IOException, InterruptedException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(projectPath + "\\src\\main\\java\\dataFiles\\Config.Properties");
		prop.load(fis);
		
		WebDriverManager.chromedriver().setup();
		WebDriver chdr = new ChromeDriver();

		G_sixthPkgSignInThroughPOMPage signInObj = new G_sixthPkgSignInThroughPOMPage(chdr);
		signInObj.signIn("UserName1","Password1");

	}

}
