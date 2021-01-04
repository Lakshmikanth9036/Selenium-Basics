package training.selenium.session09;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class LoginUsingKeywords extends LoginKeywords{

	@Test
	public void loginUsingKeywords() throws IOException {
		FileInputStream f = new FileInputStream(
				"F:\\Programs\\Selenium-Training\\selenium\\src\\test\\resources\\testdata\\excels\\keywords.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(f);
		
		XSSFSheet ws = wb.getSheet("Sheet1");
		
		Iterator<Row> rows = ws.iterator();
		
		FileInputStream fin = new FileInputStream(
				"F:\\Programs\\Selenium-Training\\selenium\\properites\\Locators.properties");
		Properties prop = new Properties();
		prop.load(fin);
		
		rows.next();
		Row row = null;
		while (rows.hasNext()) {
			row = rows.next();
			String action = row.getCell(3).getStringCellValue();
			if(action.equals("launchBrowser")){
				launchBrowser();
			}
			else if(action.equals("navigate")){
				navigate();
			}
			else if(action.equals("enterUsername")){
				enterUsername(prop.getProperty("username_txt"));
			}
			else if(action.equals("enterPassword")){
				enterPassword(prop.getProperty("password_txt"));
			}
			else if(action.equals("clickLogin")){
				clickLogin(prop.getProperty("login_btn"));
			}
			else if(action.equals("verifyTitle")){
				verifyTitle("Adactin.com - Search Hotel");
			}
		}
	}

}
