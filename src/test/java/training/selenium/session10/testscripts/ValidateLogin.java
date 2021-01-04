package training.selenium.session10.testscripts;

import org.testng.annotations.Test;

import training.selenium.session10.BasePage;
import training.selenium.session10.HomePage;
import training.selenium.session10.SearchHotelPage;

public class ValidateLogin extends BasePage{
	
	@Test
	public void validateLoginTest() {
		driver.get("http://adactinhotelapp.com/");
		HomePage homePage = new HomePage(driver);
		SearchHotelPage searchHotelPage = new SearchHotelPage(driver);
		homePage.login("kanth123", "kanth123");
		searchHotelPage.verifyTitle("Adactin.com - Search Hotel", driver);
	}
}
