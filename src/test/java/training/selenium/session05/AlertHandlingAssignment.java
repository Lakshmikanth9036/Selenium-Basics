package training.selenium.session05;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import training.selenium.config.Configuration;

public class AlertHandlingAssignment {
	private WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = Configuration.webConfig();
		driver.get("http://demo.guru99.com/v4/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void alertHandlingTest() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr26593");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("1!");
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		driver.findElement(By.xpath("//a[text()='Delete Customer']")).click();
		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("2345130");
		driver.findElement(By.xpath("//input[@name='AccSubmit']")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		Thread.sleep(3000);
		alert.accept();
		Thread.sleep(3000);
		System.out.println(alert.getText());
		alert.accept();
	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
