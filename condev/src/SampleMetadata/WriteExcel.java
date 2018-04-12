package SampleMetadata;
 
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class WriteExcel {
	
	static //define an Excel Work Book
	FileInputStream file;
	   static XSSFWorkbook workbook;
	   //define an Excel Work sheet
	   static  XSSFSheet sheet;
	   
	//public  void writeXLSX(String excel, String Sheet, String val, int rowindex, int colindex ) throws Exception
	public  void writeXLSX(String excel, String Sheet, String val1, int rowindex, int colindex ) throws Exception
	{
		file=new FileInputStream(excel);
	   workbook = new XSSFWorkbook(file);
	   XSSFSheet sheet = workbook.getSheet(Sheet);   
	    XSSFCell cell2Update1 = sheet.getRow(rowindex).getCell(colindex);
	  //  XSSFCell cell2Update2 = sheet.getRow(rowindex).getCell(colindex2);

	
	cell2Update1.setCellValue(val1);
	//cell2Update2.setCellValue(val2);
	file.close();
	FileOutputStream outputStream = new FileOutputStream(excel);
	workbook.write(outputStream);
	
	workbook.close();
	outputStream.close();
    }
}


