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

public class RadioButtonHandling {
	private WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = Configuration.webConfig();
		driver.get("http://echoecho.com/htmlforms10.htm");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void radioButtonTest() throws InterruptedException {
		List<WebElement> radioBtns = driver.findElements(By.xpath("//input[@name='group1']"));
		for (WebElement radioBtn : radioBtns) {
			radioBtn.click();
			Thread.sleep(2000);
			radioBtns = driver.findElements(By.xpath("//input[@name='group1']"));
			for (WebElement radioBtn1 : radioBtns) {
				System.out.println(
						radioBtn1.getAttribute("value") + "------------------" + radioBtn1.getAttribute("checked"));
			}
			System.out.println("=======================================");
		}
		
	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
