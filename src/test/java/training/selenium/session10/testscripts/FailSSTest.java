package training.selenium.session10.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import training.selenium.config.Configuration;
import training.selenium.config.utility.Utility;
import training.selenium.session10.HomePage;
import training.selenium.session10.SearchHotelPage;

public class FailSSTest {
	public WebDriver driver;

	@BeforeTest
	public void setup() {
		driver = Configuration.webConfig();
	}

	@Test
	public void validateLoginTest() {
		driver.get("http://adactinhotelapp.com/");
		HomePage homePage = new HomePage(driver);
		SearchHotelPage searchHotelPage = new SearchHotelPage(driver);
		homePage.login("kanth123", "kanth1234");
		searchHotelPage.verifyTitle("Adactin.com - Search Hotel", driver);
	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		// Here will compare if test is failing then only it will enter into if
		// condition
		if (ITestResult.FAILURE == result.getStatus()) {
			Utility.captureScreenshot(driver, "Login Failed");
			System.out.println("Screenshot taken");
		}

		driver.quit();
	}
}
