package SQAUpload;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class funRepo {
	
	 static{
	        
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
	        System.setProperty("current.date.time", dateFormat.format(new Date()));
	    }
	
	
	private static Logger Log = Logger.getLogger(CreateSQA.class.getName());
	public  void loGin(Properties p, WebDriver driver) throws Exception  {
		
		DOMConfigurator.configure("log4j.xml");
		Log.info("Initiate the Browser");
		driver.get(p.getProperty("url")+"/Account/Login.aspx");
		Log.info("Navigate to CDS Login page");
	    Thread.sleep(1000);
		Thread.sleep(1000);
		driver.findElement(By.id(p.getProperty("txtUserName"))).clear();
	    driver.findElement(By.id(p.getProperty("txtUserName"))).sendKeys(p.getProperty("UserName"));
	    driver.findElement(By.id(p.getProperty("txtPassword"))).clear();
	    driver.findElement(By.id(p.getProperty("txtPassword"))).sendKeys(p.getProperty("Password"));
	    driver.findElement(By.id(p.getProperty("btnLogin"))).click(); 
  
		  }


	public  void editSQA(Properties p,WebDriver driver, String BookId, String Chapter) throws Exception {
		try {
				driver.get(p.getProperty("url")+"/Lessons/Books/ChapterList.aspx?id="+BookId+"");
				System.out.println(p.getProperty("url")+" "+BookId+" "+Chapter);
				Log.info("Navigated to  Book : "+BookId);
				Thread.sleep(5000);
			    driver.findElement(By.partialLinkText(Chapter)).click();
			    Thread.sleep(5000);
			    Log.info("Navigated to  Chapter : "+Chapter);
			    driver.findElement(By.xpath(p.getProperty("EditLinkSQA"))).click();
			    Thread.sleep(5000);
		}
		catch (Exception e) {
		    Log.error( "failed!", e );
		} 
	   
        Log.info("Creating Questions for the Chapter : "+Chapter);


	}
	
	public void SaveSQA(Properties p,WebDriver driver,String DisplayName, String Keyword)
	{
		driver.findElement(By.id(p.getProperty("txtKeyword"))).clear();
	    driver.findElement(By.id(p.getProperty("txtKeyword"))).sendKeys(Keyword);
	    driver.findElement(By.id(p.getProperty("txtDisplayName"))).clear();
	    driver.findElement(By.id(p.getProperty("txtDisplayName"))).sendKeys(DisplayName);
	    driver.findElement(By.id(p.getProperty("btnSave"))).click();
	    Log.info("Question Set is created..... ");
	}
	
	
	
	
	public void AddQuestins(Properties p,WebDriver driver,String Question,String Answer, String QuestionImage, String BloomLevel,String Complexity, int i) throws Exception
	{
		String parentHandle = driver.getWindowHandle();
	    driver.findElement(By.xpath("(//a[contains(text(),'Edit')])["+i+"]")).click();
	    Thread.sleep(2000);
	    for (String winHandle : driver.getWindowHandles()) {
	          driver.switchTo().window(winHandle);
	    }
		
		driver.switchTo().frame(0);
	      WebElement q1  =  driver.switchTo().activeElement();
	      new Actions(driver).moveToElement(q1).perform();
	      driver.findElement(By.xpath("/html/body")).clear();
	      driver.findElement(By.xpath("/html/body")).sendKeys(Question);
	     
	     
	     
	      
	      
	      for (String winHandle : driver.getWindowHandles()) {
	          driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
	     } 
	      
	      //Check for Question image is available or not
	      if(QuestionImage.length()> 0) 
	      {
	    	 UploadImage(p,driver,QuestionImage,i);
	    	    
	      }
	      
	     
	      
	      driver.switchTo().frame(1);
	      WebElement Ans1  =  driver.switchTo().activeElement();
	      new Actions(driver).moveToElement(Ans1).perform();
	      driver.findElement(By.xpath("/html/body")).clear();
	      driver.findElement(By.xpath("/html/body")).sendKeys(Answer); 
	      
	      for (String winHandle : driver.getWindowHandles()) {
	          driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
	     } 
	      
	      
	      
	      Select oSelect = new Select(driver.findElement(By.id("MainContent_SQAEditor_ddlBloomLevel")));
        switch(BloomLevel) {
        case "Remember" :
        oSelect.selectByVisibleText("1 - Remember");
        break;
        case "Understand" :
            oSelect.selectByVisibleText("2 - Understand");
            break;
        case "Apply" :
            oSelect.selectByVisibleText("3 - Apply");
            break;
        case "Analyse" :
            oSelect.selectByVisibleText("4 - Analyze");
            break;
        case "Evaluate" :
            oSelect.selectByVisibleText("5 - Evaluate");
            break;
        case "Create" :
      	  oSelect.selectByVisibleText("6 - Create");
            break;
         default :
           System.out.println("Bloom Level is not defined ");
            break;
        
        }
	      
        switch(Complexity){
        case "Easy" :
        	driver.findElement(By.id("rbComplexity_0")).click();
        	break;
        case "Medium" :
        	driver.findElement(By.id("rbComplexity_1")).click();
        	break;
        case "Difficult" :
          	driver.findElement(By.id("rbComplexity_2")).click();
          	break;
        	default :
        		System.out.println("Complexity is not defined ");
        	
        }
	      Thread.sleep(5000);
	      driver.findElement(By.id("MainContent_SQAEditor_btnSave")).click();
	      Thread.sleep(5000);
	      Log.info("Question No. "+i+" has been created......");
	      driver.switchTo().window(parentHandle);
	}
	
	public void UploadImage(Properties p,WebDriver driver,String QuestionImage,int i) throws InterruptedException
	{
		Thread.sleep(5000);
  	   driver.findElement(By.id(p.getProperty("QImageBtn"))).click();
  	   Thread.sleep(2000);
    
  	  for (String winHandles : driver.getWindowHandles()) {
  		  driver.switchTo().window(winHandles); }
    
  	  driver.findElement(By.name(p.getProperty("ImgBrowseBtn"))).sendKeys(QuestionImage);
  	  Thread.sleep(2000);
  	  driver.findElement(By.name(p.getProperty("ImgUploadBtn"))).click();
  	  Thread.sleep(2000);
  	  
  	  // Switching to Alert        
      //  Alert alert = driver.switchTo().alert();
  	  driver.switchTo().alert().accept(); 
  	  
  	// Capturing alert message.    
     //   String alertMessage= driver.switchTo().alert().getText();		
        		
        // Displaying alert message		
     //   System.out.println(alertMessage);	
     //   Thread.sleep(5000);
        		
        // Accepting alert		
       // alert.accept();		
  	 
  	  Log.info("Question Image is for Question No. "+i+" has been successfully uploaded......");
  	  Thread.sleep(2000);
  	  driver.findElement(By.xpath(p.getProperty("ImgSelectBtn"))).click();
  	  Thread.sleep(2000);
  	  
  	  for (String winHandles : driver.getWindowHandles()) {
	          driver.switchTo().window(winHandles); }
  	  
  
  	  driver.findElement(By.id("MainContent_SQAEditor_QHTML_WebHtmlEditor1_ts_h")).click();
  	  Thread.sleep(5000);
  	  driver.switchTo().frame(0);
	      WebElement h1  =  driver.switchTo().activeElement();
	      new Actions(driver).moveToElement(h1).perform();
	      String text= driver.findElement(By.xpath("/html/body")).getText();
	
	      
	      System.out.println("Question Text is =====>"+text);
	
	      String  QuestionText = text.split("<img src")[0];
	 //     System.out.println("After split Question Text is =====>"+QuestionText);

	      String ImagePath="<img src"+text.split("<img src")[1];
	   //   System.out.println("After split Image Path  is =====>"+ImagePath);
	      
	      String FinalQuestion=QuestionText.replace("&lt;IMG&gt;",ImagePath);
	  //    System.out.println("After split FinalQuestion is =====>"+FinalQuestion);
	      
	      driver.findElement(By.xpath("/html/body")).clear();
	      driver.findElement(By.xpath("/html/body")).sendKeys(FinalQuestion);
	      
	      for (String winHandle : driver.getWindowHandles()) {
	          driver.switchTo().window(winHandle); }
	}
	
	
}
