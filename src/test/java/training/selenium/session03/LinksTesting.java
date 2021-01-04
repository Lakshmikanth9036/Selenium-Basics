package training.selenium.session03;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import training.selenium.config.Configuration;

public class LinksTesting {

	private WebDriver driver;

	@Test
	public void test() throws InterruptedException {

		driver = Configuration.webConfig();
		driver.get("https://www.amazon.in");

		// org.openqa.selenium.StaleElementReferenceException: stale element
		// reference: element is not attached to the page document
		List<WebElement> lists = driver.findElements(By.xpath("//div[text()='Get to Know Us']/following-sibling::ul/child::li"));
		for(int i=0; i<lists.size(); i++){
			WebElement link = driver.findElement(By.xpath("(//div[text()='Get to Know Us']/following-sibling::ul/child::li)["+(i+1)+"]")).findElement(By.tagName("a"));
			System.out.println(link.getText());
			link.click();
			Thread.sleep(2000);
			driver.navigate().back();
			Thread.sleep(2000);
		}
		
		driver.quit();
	}

}
