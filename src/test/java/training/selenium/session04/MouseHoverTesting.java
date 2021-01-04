package training.selenium.session04;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import training.selenium.config.Configuration;

public class MouseHoverTesting {
	private WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = Configuration.webConfig();
		driver.get("https://www.stepchange.org/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void mouseHoverTest() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='How we help']"))).perform();
		driver.findElement(By.xpath("//a[text()='Money advice']")).click();
	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
