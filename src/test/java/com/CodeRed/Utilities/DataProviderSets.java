package com.CodeRed.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderSets {
	public static XSSFSheet ExcelWSheet;
	public static XSSFWorkbook ExcelWBook;
	public static XSSFCell Cell;
	public static String cellData;
	
	@DataProvider(name = "changePasswordDataParticipant")
	public static Object[][] readDataFromExcelChangePwd() throws IOException {
		try {
			File Path = new File(
					"C:\\Users\\HemalathaManikandan\\eclipse-workspace\\CyberQ_2.0_Project\\src\\test\\java\\com\\CyberQ\\TestDatas\\Test Data Files\\ChangePasswordParticipant.xlsx");
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows - 1][noOfColumns];
			for (int i = 0; i < noOfRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i + 1).getCell(j));

				}
			}
			ExcelWBook.close();
			ExcelFile.close();

//		for (String[]dataArray: data) {
//			System.out.println(Arrays.toString(dataArray));	
//		}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
