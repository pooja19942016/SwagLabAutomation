package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
/*
 * This class cosisit of generic methods related to Java
 * @author pooja
 * 
 * */

public class JavaUtility {
/**
 *This method will capture system date in format and return to caller 
 */
	public String getSystemDataInFormat()
	{
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		String date = s.format(d);
		return date;
		
		
	}
	
	public void senEmail() {
		
	}
}
