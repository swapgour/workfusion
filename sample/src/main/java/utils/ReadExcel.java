package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.testng.annotations.*;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import constants.Constants;

//How to read excel files using Apache POI
public class ReadExcel 
{

	
	@DataProvider
	public String[][]  getData() throws IOException 
	{
		File excelFile = new File(Constants.excelPath);
		FileInputStream fis = new FileInputStream(excelFile);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int noOfRows = sheet.getPhysicalNumberOfRows();
		int noOfColumns = sheet.getRow(0).getLastCellNum();
		
		String[][] data = new String [noOfRows-1][noOfColumns];
		for (int i = 0; i < noOfRows-1; i++) 
		{
			for (int j = 0; j < noOfColumns; j++) 
			{
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));
				System.out.println(df.formatCellValue(sheet.getRow(i+1).getCell(j)));
			}
		}
	
		workbook.close();
		fis.close();
		
		
		return data;
	}
}