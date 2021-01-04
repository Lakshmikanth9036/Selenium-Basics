package training.selenium.session08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import training.selenium.config.Configuration;

public class UserLoginCredByXlsx {
	private WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = Configuration.webConfig();
		driver.get("http://adactinhotelapp.com/index.php");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void loginTest() throws IOException {
		FileInputStream f = new FileInputStream(
				"F:\\Programs\\Selenium-Training\\selenium\\src\\test\\resources\\testdata\\excels\\login_credential.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(f);
		XSSFSheet ws = wb.getSheet("Sheet1");
		Iterator<Row> rows = ws.iterator();
		rows.next();
		Row row = null;
		while (rows.hasNext()) {
			row = rows.next();
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(row.getCell(0).getStringCellValue());
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(row.getCell(1).getStringCellValue());
			driver.findElement(By.xpath("//input[@id='login']")).click();
			String actualTitle = driver.getTitle();
			String expectedTitle = row.getCell(2).getStringCellValue();
			Assert.assertEquals(actualTitle, expectedTitle);
			driver.navigate().to("http://adactinhotelapp.com/index.php");
		}
	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
