package training.selenium.session07;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {

	public static void main(String[] args) throws IOException {
		FileInputStream f = new FileInputStream("F:\\Programs\\Selenium-Training\\dataset\\data.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(f);
		XSSFSheet ws = wb.getSheet("Sheet1");
		
//		Case 1: Modifying existing cell
//		ws.getRow(0).getCell(3).setCellValue("Indian");
		
//		Case 2: Creating new cell 
//		ws.getRow(1).createCell(2).setCellValue("FALSE");
		
//		Case 3: Create new row and cell
		ws.createRow(2).createCell(0).setCellValue("Developer");
		
		FileOutputStream fo = new FileOutputStream("F:\\Programs\\Selenium-Training\\dataset\\data.xlsx");
		wb.write(fo);
		
		f.close();
	}
}
