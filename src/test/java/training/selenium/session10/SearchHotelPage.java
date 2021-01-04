package training.selenium.session10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchHotelPage {
	
	public SearchHotelPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//td[@class='welcome_menu'])[1]") 
	WebElement welcomeLabel;
	
	public void verifyTitle(String expTitle, WebDriver driver){
		Assert.assertEquals(driver.getTitle(), expTitle);
	}
}
