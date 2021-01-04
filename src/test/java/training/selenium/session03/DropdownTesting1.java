package training.selenium.session03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import training.selenium.config.Configuration;

public class DropdownTesting1 {
	
	
	private WebDriver driver;

	@Test
	public void test() throws InterruptedException {

		driver = Configuration.webConfig();
		driver.get("https://www.amazon.in");

		driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry Potter");

		driver.findElement(By.id("nav-search-submit-text")).click();

		Thread.sleep(5000);

		driver.quit();

	}
}