package training.selenium.session05;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import training.selenium.config.Configuration;

public class SwitchToFrame {
	private WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = Configuration.webConfig();
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void switchToFrameTest() {
		
		driver.switchTo().frame(0);
		WebElement block = driver.findElement(By.xpath("//ul[@title='Packages']"));
		List<WebElement> links = block.findElements(By.tagName("a"));
		links.forEach(link -> {
			System.out.println(link.getText());
		});
	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
}
