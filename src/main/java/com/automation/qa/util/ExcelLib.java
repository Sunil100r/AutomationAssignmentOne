package com.automation.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib {
//get data present in specified cell of xl sheet
public String getXlCellValue(String xlPath,String sheetName,int rowNum,int cellNum) throws Exception
{
	 rowNum=rowNum-1;
	 cellNum=cellNum-1;
	 try {
	   FileInputStream fis=new FileInputStream(xlPath);
	   Workbook wb = WorkbookFactory.create(fis);
	   Sheet sh= wb.getSheet(sheetName);
	   Row rw= sh.getRow(rowNum);
	   DataFormatter formatter = new DataFormatter();
	  String val=formatter.formatCellValue(rw.getCell(cellNum));
	  
	  return val;
	 } 
	catch ( Exception e) {
		return null;
	}
	
}
	

}








