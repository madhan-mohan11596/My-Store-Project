/**
 * 
 */
package com.ReadExcel;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

/**
 * @author ambul
 *
 */
public class ReadExcel 
{
	@Test
	public void readExcel() throws Exception  
	{
		
		String excelFilePath = "C:\\Users\\ambul\\eclipse-workspace\\MyStoreProject\\src\\test\\resources\\TestData\\My Store Test Data.xlsx";
		String FileName = "My Store Test Data";
		String SheetName = "TestData";
		
		File file = new File(excelFilePath);
		FileInputStream fis = new FileInputStream(file);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet st = wb.getSheet(SheetName);
		int totalRows = st.getLastRowNum();
		System.out.println("total no. of rowrs :"+totalRows);
		
		for(int i=0 ;i<=totalRows;i++) 
		{
			Row row = st.getRow(i);
			for(int j=0 ;j<row.getLastCellNum() ;j++)
			{
				
				String data = row.getCell(j).getStringCellValue();
				System.out.print(data + " ");
			}
			
			System.out.println();
		}
		wb.close();
	}
}
