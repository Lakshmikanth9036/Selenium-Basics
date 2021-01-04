package training.selenium.session10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id='username']") 
	WebElement username;
	
	@FindBy(xpath="//input[@id='password']") 
	WebElement password;
	
	@FindBy(xpath="//input[@id='login']") 
	WebElement login;
	
	public void login(String username, String password){
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		this.login.click();
	}
}
