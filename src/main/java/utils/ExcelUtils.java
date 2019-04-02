package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtils {
	
	public static void ReadExcelData(String filepath,String filename,String sheetname) throws IOException{
	   //open the file in input mode for reading from Excel
		FileInputStream inputStream = new FileInputStream(filepath +"/" + filename);
		//please note i am doing for xlsx 
		//for xlsx the workbook is XSSFWorkbook for xls you have to create an instance HSSFWorkbook;
		//if(filename.endsWith(".xlsx"))
		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
		//Sheername 
		Sheet sheet = workbook.getSheet(sheetname);
		//RowCount 
		int rowCount = sheet.getLastRowNum();
		System.out.println("RowCount = " + rowCount);
		for(int r=0;r<rowCount+1;r++){
			Row row = sheet.getRow(r);
			for(int c=0;c<row.getLastCellNum();c++){
				Cell cell = row.getCell(c);
				System.out.print(cell.getStringCellValue() + "\t");
			}
			System.out.println("");
		}
	}
	
	public static Object[][] ReadExcelDataToObjectArray(String filepath,String filename,String sheetname) throws IOException{
		FileInputStream inputStream = new FileInputStream(filepath +"/" + filename);
		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetname);
		int rowCount = sheet.getLastRowNum();
		Object[][] data = new Object[rowCount][1];
		//get the header row 
		Row headerRow = sheet.getRow(0);
		//for data rows - lets do for loop with r as counter
		Hashtable <String,String> record = null;
		for(int r=1;r<rowCount+1;r++){
			//lets get the data row
			Row dataRow = sheet.getRow(r); //current row starting with r=1
			record = new Hashtable<String,String>();
			//loop through cells
			for(int c=0;c<dataRow.getLastCellNum();c++){
				String key = headerRow.getCell(c).getStringCellValue();
				String val = dataRow.getCell(c).getStringCellValue();
				record.put(key, val);
			}
			data[r-1][0] = record;
		}
		return data;
	}
	public static void main(String args[]) throws IOException{
		//here we are checking the ReadExcelData is working dine
		//by calling it to execute it
		String ProjectPath = System.getProperty("user.dir"); 
		String filepath = ProjectPath + "/src/com/project/testdata";
		String filename = "CalorieTestData.xlsx";
		String sheetname ="CalorieTestSet";
		ExcelUtils.ReadExcelData(filepath, filename, sheetname);
	
	}

	
}

