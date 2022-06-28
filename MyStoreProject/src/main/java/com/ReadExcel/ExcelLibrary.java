/**
 * 
 */
package com.ReadExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author ambul
 *
 */
public class ExcelLibrary {
	
	XSSFWorkbook wb;
	XSSFSheet st;
	
	public ExcelLibrary() throws Exception 
	{
		
		String excelFilePath = "C:\\Users\\ambul\\eclipse-workspace\\MyStoreProject\\src\\test\\resources\\TestData\\My Store Test Data.xlsx";
		File file = new File(excelFilePath);
		FileInputStream fis = new FileInputStream(file);
		
		 wb = new XSSFWorkbook(fis);

		
	}
	
	public String ReadSingleCell(String sheetname,int row,int col) {
		
		st = wb.getSheet(sheetname);
		String data = st.getRow(row).getCell(col).getStringCellValue();
		return data;
		
	}
	
	

}
