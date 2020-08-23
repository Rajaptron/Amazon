package com.amazon.qa.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Apache_POI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Object[][] arrayObject =getExcelData(System.getProperty("user.dir")
				+ "/src/main/java/Com/Amazon/qa/data/LoginData.xls","Sheet1");
		
		System.out.println(arrayObject[0][0]);
		

	}
	

	
	public static String[][] getExcelData(String fileName, String sheetName) {
		
		String[][] arrayExcelData = null;
		
		try {
			FileInputStream fs = new FileInputStream(fileName);
			
			Workbook wb = Workbook.getWorkbook(fs);
			
			Sheet sh = wb.getSheet(sheetName);
			
			int totalNoOfCols = sh.getColumns();
			
			int totalNoOfRows = sh.getRows();
			
			arrayExcelData = new String[totalNoOfRows - 1][totalNoOfCols];
			
			for (int i = 1; i < totalNoOfRows; i++) {
				
				for (int j = 0; j < totalNoOfCols; j++) {
					
				arrayExcelData[i - 1][j] = sh.getCell(j, i).getContents();}}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();} 
		catch (IOException e) {
			e.printStackTrace();} 
		catch (BiffException e) {
			e.printStackTrace();}
		return arrayExcelData;
	}
	

}
