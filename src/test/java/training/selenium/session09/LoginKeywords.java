package training.selenium.session09;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;
import training.selenium.config.Configuration;

public class LoginKeywords {
	private WebDriver driver;
	
	public void launchBrowser(){
		driver = Configuration.webConfig();
	}
	
	public void navigate(){
		driver.get("http://adactinhotelapp.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void enterUsername(String locator){
		driver.findElement(By.xpath(locator)).sendKeys("kanth123");
	}
	
	public void enterPassword(String locator){
		driver.findElement(By.xpath(locator)).sendKeys("kanth123");
	}
	
	public void clickLogin(String locator){
		driver.findElement(By.xpath(locator)).click();
	}
	
	public void verifyTitle(String expectedTitle){
		Assert.assertEquals(expectedTitle, driver.getTitle());
	}
}

