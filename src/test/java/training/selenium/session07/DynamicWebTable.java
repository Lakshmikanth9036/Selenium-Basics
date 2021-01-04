package training.selenium.session07;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import training.selenium.config.Configuration;

public class DynamicWebTable {
	private WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = Configuration.webConfig();
		driver.get("https://www.timeanddate.com/worldclock/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void dynamicWebTableTest() throws InterruptedException {
		WebElement tabel = driver.findElement(By.tagName("tbody"));
		List<WebElement> rows = tabel.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			List<WebElement> cols = row.findElements(By.tagName("td"));
			for (WebElement col : cols) {
				System.out.print(col.getText() + "\t");
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
