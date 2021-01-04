package training.selenium.session07;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import training.selenium.config.Configuration;

public class StaticWebTable {
	private WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = Configuration.webConfig();
		driver.get("https://www.timeanddate.com/worldclock/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void staticWebTableTest() throws InterruptedException {
		for (int i = 1; i <= 36; i++) {
			for (int j = 1; j <= 8; j++) {
				WebElement city = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[" + j + "]"));
				System.out.print(city.getText() + "\t");
			}
			System.out.println();
		}
	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
