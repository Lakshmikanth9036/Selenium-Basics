package training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import training.selenium.config.Configuration;

public class AppTest {
	private WebDriver driver;

	@Test
	public void flipkartTest() throws InterruptedException {
		driver = Configuration.webConfig();
		driver.get("https://www.google.com");

		WebElement googleSearchBox = driver.findElement(By.className("gLFyf"));
		googleSearchBox.sendKeys("flipkart");
		googleSearchBox.sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//*[@id='tads']/div/div/div/div[1]/a/div[1]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();

		// Webdriver Methods
		System.out.println("Current URL ==> " + driver.getCurrentUrl());
		// System.out.println(driver.getPageSource());
		System.out.println("Title ==> " + driver.getTitle());
		System.out.println("Window ==> " + driver.getWindowHandle());

		WebElement flipkartSearchBox = driver
				.findElement(By.xpath("//*[@id='container']/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input"));
		flipkartSearchBox.sendKeys("shoes for men");

		// WebElement Methods
		System.out.println("Get Attribute ==> " + flipkartSearchBox.getAttribute("value"));
		System.out.println("Get Tag Name ==> " + flipkartSearchBox.getTagName());
		System.out.println("Get Text ==> " + flipkartSearchBox.getText());
		flipkartSearchBox.sendKeys(Keys.ENTER);

		// Navigate Method
		driver.navigate().to("https://www.flipkart.com/");
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();

		Thread.sleep(2000);
		// Actions
		Actions actions = new Actions(driver);
		WebElement category = driver.findElement(By.xpath("//*[@id='container']/div/div[2]/div/div/span[3]"));
		actions.moveToElement(category).perform();

		Thread.sleep(3000);
		driver.close();
		driver.quit();
	}
	

}