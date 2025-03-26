package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/*
 * This class conssits of generic methods related To Files 
 * like propery file, Excel File
 * @author pooja
 * */
public class FileUtility {
	
	/**
	 * This method will read data from property file and return 
	 * the value to caller
	 * @author pooja
	 * @return 
	 * @throws IOException 
	 * 
	 */
	public String readDataFromPropertyFile(String key) throws IOException 
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;	
	}
	/*
	 * This method will read data from excel based on row and cell number 
	 * and ruturn the value to caller
	 * @param SheetName
	 * 
	 * */
	
	
	public String readDataFromExcel(String SheetName, int rowNo, int cellNo) throws IOException
	
	
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb =WorkbookFactory.create(fis);
		String value = wb.getSheet(SheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
	}

}
