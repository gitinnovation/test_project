package com.util.repo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class automationFunctions {
	
	private XSSFWorkbook workbook;

	public void iterateElementArray(WebDriver driver, String ele_xpath, int row, int col, String value) throws InterruptedException
		{	
		
		outerloop:
		for ( int i=0;i<=row;i++)
			{
			for ( int j=0;j<=col;j++)
				{
				WebElement ele=driver.findElement(By.xpath(ele_xpath+i+"_"+j+"']"));
				String monval=ele.getText();;
				System.out.println(ele_xpath+i+"_"+j+"']");
				System.out.println(monval);
					if(monval.equals(value))
							{ele.click();
								break outerloop;}
				}
			}
		}
	
	
	
	
	
	
	public void calenderControl(WebDriver driver,WebElement calender, WebElement title,String years,String months,String dates,String year,String month,String date) throws Exception
	{
	
 		WebDriverWait wait_calender = new WebDriverWait(driver, 10);
 		wait_calender.until(ExpectedConditions.visibilityOf(calender));
 		calender.click();
 		
 		WebDriverWait wait_title = new WebDriverWait(driver, 10);
 		wait_title.until(ExpectedConditions.visibilityOf(title));		 				 				 		
 		title.click();
 		Thread.sleep(1000);
 		title.click();
		
		WebDriverWait wait_years = new WebDriverWait(driver, 10);
		wait_years.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(years+"0_0']")));
		//iterate years
		iterateElementArray(driver, years, 2, 3, year);
		
		
		WebDriverWait wait_month = new WebDriverWait(driver, 10);
		wait_month.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(months+"0_0']")));
		//iterate months
		iterateElementArray(driver, months, 2, 3, month);

		WebDriverWait wait_date = new WebDriverWait(driver, 10);
		wait_date.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dates+"0_0']")));
		//iterate dates
		iterateElementArray(driver, dates, 6, 6, date);
	}
	
	public Properties getObjectRepository(String ORFile) throws IOException
	{	
		Properties p=new Properties();
		//Read object repository file
		InputStream stream=new FileInputStream(new File(System.getProperty("user.dir")+ORFile));
		//load all objects
		p.load(stream);
		return p;
	}
	
	public String[][] readXLSX(String excel, String Sheet) throws Exception {
	
	String[][] data;
	FileInputStream fs=new FileInputStream(excel);
	workbook = new XSSFWorkbook(fs);
	XSSFSheet sheet = workbook.getSheet(Sheet);

	
	int totalNoofRow =sheet.getLastRowNum();
	int totalnoOfCol = sheet.getRow(1).getPhysicalNumberOfCells();
	
	System.out.println("Total No of Row=" +totalNoofRow);
	
	System.out.println("Total No of Column="+totalnoOfCol);
	
	System.out.println("");
	
	data=new String [totalNoofRow][totalnoOfCol];
	for(int row=1; row<= totalNoofRow;row++) {
	for(int col=0;col<totalnoOfCol;col++)
	{
	  
		DataFormatter formatter = new DataFormatter();
		data[row-1][col] = formatter.formatCellValue(sheet.getRow(row).getCell(col));
		System.out.println(formatter.formatCellValue(sheet.getRow(row).getCell(col))+"\t");

		
	}
	System.out.println("");
	
	}
	return data;

    }


	/*public void iterateWebTabley(WebDriver driver, String ele_xpath, int row, int col, String value) throws InterruptedException
	{	
	
		WebElement ele=driver.findElement(By.xpath(ele_xpath+i+"_"+j+"']"));
	outerloop:
	for ( int i=0;i<=row;i++)
		{
		for ( int j=0;j<=col;j++)
			{
			WebElement ele=driver.findElement(By.xpath(ele_xpath+i+"_"+j+"']"));
			String monval=ele.getText();;
			System.out.println(ele_xpath+i+"_"+j+"']");
			System.out.println(monval);
				if(monval.equals(value))
						{ele.click();
							break outerloop;}
			}
		}
	}*/

	
}
