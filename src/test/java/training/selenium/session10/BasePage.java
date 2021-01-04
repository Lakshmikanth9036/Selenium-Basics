package training.selenium.session10;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import training.selenium.config.Configuration;

public class BasePage {
	public WebDriver driver;

	@BeforeTest
	public void setup() {
		driver = Configuration.webConfig();
	}

	@AfterTest
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
