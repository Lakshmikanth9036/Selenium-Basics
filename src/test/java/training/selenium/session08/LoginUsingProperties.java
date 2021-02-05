package training.selenium.session08;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import training.selenium.config.Configuration;

public class LoginUsingProperties {
	private WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = Configuration.webConfig();
		driver.get("http://adactinhotelapp.com/index.php");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void loginTest() throws IOException {
		FileInputStream fin = new FileInputStream(
				"F:\\Programs\\Selenium-Training\\selenium\\properites\\Locators.properties");
		Properties prop = new Properties();
		prop.load(fin);

		driver.findElement(By.xpath(prop.getProperty("username_txt"))).sendKeys("kanth123");
		driver.findElement(By.xpath(prop.getProperty("password_txt"))).sendKeys("kanth123");
		driver.findElement(By.xpath(prop.getProperty("login_btn"))).click();

	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
