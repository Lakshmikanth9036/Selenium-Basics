package training.selenium.session04;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import training.selenium.config.Configuration;

public class MultipleWindow {
	private WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = Configuration.webConfig();
		driver.get("https://www.stepchange.org/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void multipleWindowTest() {
		String homeWindow = driver.getWindowHandle();
//		driver.findElement(By.xpath("//a[@id='CybotCookiebotDialogBodyButtonAccept']")).click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//img[@alt='Facebook icon']")));
		

		Set<String> windowIds = driver.getWindowHandles();

		Iterator<String> itr = windowIds.iterator();

		while (itr.hasNext()) {
			driver.switchTo().window(itr.next());
			try {
				driver.findElement(By.xpath("//label[@id='loginbutton']")).click();
				
				driver.switchTo().window(homeWindow);
				break;
			} catch (Exception e) {
			}
		}

	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
