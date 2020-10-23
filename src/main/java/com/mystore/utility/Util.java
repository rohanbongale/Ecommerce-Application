package com.mystore.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Util {
	
	static String path = System.getProperty("user.dir");
	public static String TestData_FilePath=path+"\\TestData\\TestcaseData.xlsx";
	public static XSSFWorkbook wbook;
	public static XSSFSheet sheet;
	
	public static Object[][] getdata(String sheetName) throws IOException {
		try 
		{
		FileInputStream fis=new FileInputStream(TestData_FilePath);

		wbook=new XSSFWorkbook(fis);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		sheet=wbook.getSheet(sheetName);
		int totRows=sheet.getLastRowNum();
		int totColumns=sheet.getRow(0).getLastCellNum();
		Object[][] data=new Object[totRows][totColumns];
		for(int i=0;i<totRows;i++)
		{	
			for(int j=0;j<totColumns;j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}		
		}
		return data;
		
	}

}
