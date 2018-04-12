package ResultOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {
	//define an Excel Work Book
	  XSSFWorkbook workbook;
	  //define an Excel Work sheet
	  XSSFSheet sheet;
	  //define a test result data object
	  Map<String, Object[]> testresultdata;
	  
	  public void DefineExcel()
	  {
		   //create a new work book
		    workbook = new XSSFWorkbook();
	       //create a new work sheet
	        sheet = workbook.createSheet("Test Result");
	        testresultdata = new LinkedHashMap<String, Object[]>();
	        //add test result excel file column header
	        //write the header in the first row
	        testresultdata.put("1", new Object[] {"S.No.", "Input", "Result"});
	      
	  }
	  
	  public void GenerateExcelReport() {
		    //write excel file and file name is TestResult.xls 
		    Set<String> keyset = testresultdata.keySet();
		    int rownum = 0;
		    for (String key : keyset) {
		        Row row = sheet.createRow(rownum++);
		        Object [] objArr = testresultdata.get(key);
		        int cellnum = 0;
		        for (Object obj : objArr) {
		            Cell cell = row.createCell(cellnum++);
		            if(obj instanceof Date) 
		                cell.setCellValue((Date)obj);
		            else if(obj instanceof Boolean)
		                cell.setCellValue((Boolean)obj);
		            else if(obj instanceof String)
		                cell.setCellValue((String)obj);
		            else if(obj instanceof Double)
		                cell.setCellValue((Double)obj);
		        }
		    }
		    try {
		        FileOutputStream out =new FileOutputStream(new File("TestResult.xlsx"));
		        workbook.write(out);
		        out.close();
		        System.out.println("Excel written successfully..");
		         
		    } catch (FileNotFoundException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		    //close the browser
		//    driver.close();
		//    driver.quit();
		  }

}
