package training.selenium.session06;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import training.selenium.config.Configuration;

public class CheckBoxHandling {
	private WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = Configuration.webConfig();
		driver.get("http://echoecho.com/htmlforms09.htm");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void checkBoxTest() throws InterruptedException {
		List<WebElement> checkboxs = driver.findElements(By.xpath("(//td[@class='table5'])[2]/child::input"));
		for (WebElement checkbox : checkboxs) {

			if (!checkbox.isSelected()) {
				checkbox.click();
			}
			System.out
					.println(checkbox.getAttribute("value") + "------------------" + checkbox.getAttribute("checked"));

		}
	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
