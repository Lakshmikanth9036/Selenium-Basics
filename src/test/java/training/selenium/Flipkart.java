package training.selenium;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import training.selenium.config.Configuration;

public class Flipkart {
	private WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = Configuration.webConfig();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void checkBoxTest() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//span[text()='Men']"))).perform();
		driver.findElement(By.xpath("//a[text()='Formal Shirts']")).click();
		driver.findElement(By.xpath("(//div[@class='_13oc-S']/div)[1]")).click();
		Set<String> windows = driver.getWindowHandles();
		String currentWindow = driver.getWindowHandle();
		System.out.println(currentWindow);
		windows.forEach(window -> {
			if(!window.equals(currentWindow))
				driver.switchTo().window(window);	
		});
		System.out.println(driver.getWindowHandle());
		
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		
		js.executeScript("window.scrollTo(0,500)");
		driver.findElement(By.xpath("//a[text()='40']")).click();
		js.executeScript("window.scrollTo(0,500)");
		
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA ihZ75k _3AWRsL']")).click();
		driver.close();
		driver.switchTo().window(currentWindow);
		System.out.println(driver.getWindowHandle());
		actions.moveToElement(driver.findElement(By.xpath("//span[text()='Electronics']"))).perform();
		WebElement electronics = driver.findElement(By.xpath("(//div[@class='_1fwVde'])[1]"));
		List<WebElement> brands = electronics.findElements(By.tagName("a"));
		List<String> brandNames = brands.stream().map(WebElement::getText).collect(Collectors.toList());
		brandNames.forEach(System.out::println);
	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
