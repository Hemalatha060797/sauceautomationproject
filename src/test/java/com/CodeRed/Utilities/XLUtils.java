package com.CodeRed.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static XSSFSheet ExcelWSheet;
	public static XSSFWorkbook ExcelWBook;
	public static XSSFCell Cell;
    public static String cellData;
	
	
	public static int getRowCount(String xlfile,String xlsheet) throws IOException 
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		int rowcount=ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;		
	}
	
	
	public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		int cellcount=row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}
	
	
	public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		try 
		{
			DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
		}
		catch (Exception e) 
		{
			data="";
		}
		wb.close();
		fi.close();
		return data;
	}
	
	public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);		
		wb.close();
		fi.close();
		fo.close();
	}
public String readExcelData(String data) throws IOException {
		
    	String values []=data.split(",");
    	String path= values[0];
    	
    	int sheetNumber = Integer.valueOf(values[1]);
    	int rowNumber = Integer.valueOf(values[2]);
    	int columnNumber = Integer.valueOf(values[3]);
    	try {
    	File f= new File(path);
    	FileInputStream fis= new FileInputStream(f);
    	ExcelWBook = new XSSFWorkbook(fis);
		ExcelWSheet = ExcelWBook.getSheetAt(sheetNumber);
		XSSFRow row = ExcelWSheet.getRow(rowNumber);
    	XSSFCell cell2 = row.getCell(columnNumber);
    	 cellData = cell2.getStringCellValue();
    	 ExcelWBook.close();
    	 
    	return data;
    	}catch(IOException io) {
    		io.printStackTrace();
    	}
	 return cellData;	 
 }
	
//public Object[][] getData(){
//	
//	XLUtils xl= new XLUtils();
//	
//	String path= System.getProperty("user.dir")+"\\Login data.xlsx";
//	String[][] data= new String[][] {
//		{xl.readExcelData(path+",0,2,1")}
//	}
//
//	return null;
//	
}
