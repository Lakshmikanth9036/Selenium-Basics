package training.selenium.session05;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import training.selenium.config.Configuration;

public class ExplicitAndFluentWait {
	private WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = Configuration.webConfig();
		driver.get("https://www.24hourfitness.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void explicitAndFluentTest() throws InterruptedException {
		WebDriverWait mywait = new WebDriverWait(driver, 20);
//		FluentWait<WebDriver> mywait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
//				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Learn More'])[1]"))).click();
	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
