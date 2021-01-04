package training.selenium.session08;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import training.selenium.config.Configuration;

public class UserLoginUsingDataProvider {
	private WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = Configuration.webConfig();
		driver.get("http://adactinhotelapp.com/index.php");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(dataProvider = "getData")
	public void loginTest(String username, String password, String title) throws IOException {

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='login']")).click();
		String actualTitle = driver.getTitle();

		Assert.assertEquals(actualTitle, title);

	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		FileInputStream f = new FileInputStream(
				"F:\\Programs\\Selenium-Training\\selenium\\src\\test\\resources\\testdata\\excels\\login_credential.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(f);
		XSSFSheet ws = wb.getSheet("Sheet1");
		int numRows = ws.getLastRowNum();

		Object[][] obj = new Object[numRows][3];

		for (int i = 0, j = 1; i < numRows; i++, j++) {
			obj[i][0] = ws.getRow(j).getCell(0).getStringCellValue();
			obj[i][1] = ws.getRow(j).getCell(1).getStringCellValue();
			obj[i][2] = ws.getRow(j).getCell(2).getStringCellValue();
		}

		return obj;
	}

}
