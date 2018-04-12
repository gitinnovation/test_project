package MCQQuestionTagging;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import SQAUpload.funRepo;
import operation.ReadObject;
import ReadExcel.readExcel;

public class QuestionTagging {
	private WebDriver driver;
	  funRepo fR=new funRepo();
	  ReadObject object=new ReadObject();
	  

	  @DataProvider(name="Tagging")
		public static Object[][] readExcel() throws  Exception {
		 
		 readExcel re = new readExcel();
			return re.readXLSX("D:\\Automation\\QuestionTagging1.xls", "Sheet1"); 
	
		}
	  

	  @BeforeClass(alwaysRun= true)
		public void setup() throws Exception  {
		Properties P= object.getObjectRepository();
		System.setProperty("webdriver.chrome.driver","D:\\Automation\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		fR.loGin(P,driver);		
		driver.findElement(By.linkText("My Page")).click();
			  }
	  
	  
	  @Test(dataProvider="Tagging", priority=2 )
	  public void Tagging(String QID, String TopicID, String RID,String SubjectID, String MediaType, String BloomLevel, String Complexity) throws Exception {
		  Properties P= object.getObjectRepository();
		 // driver.get(baseUrl + "/Lessons/Books/AddQuestion.aspx?QId=0000266900026405&TopicID=138591&Type=HOT&RID=CDS2000100510317&Subject=14&MediaType=SWF");
		  driver.get(P.getProperty("url")+ "/Lessons/Books/AddQuestion.aspx?QId="+QID+"&TopicID="+TopicID+"&Type=HOT&RID="+RID+"&Subject="+SubjectID+"&MediaType="+MediaType+"");
		
		  BloomLevel(P,BloomLevel,QID);
          
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
          		System.out.println("Complexity is not defined for QID="+QID);
          	
          }
          Thread.sleep(4000);
		  
          driver.findElement(By.id("btnSubmit")).click();
          Thread.sleep(4000);
          driver.get(baseUrl+"/Lessons/Elements/ReeditElements.aspx");
	  }
	  
	  public void BloomLevel(Properties P,String BloomLevel,String QID)
	  {
		  Select oSelect = new Select(driver.findElement(By.id("MainContent_AddToQuestionBank1_QuestionEditor1_ddlBloomLevel")));
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
             System.out.println("Bloom Level is not defined for QID="+QID);
              break;
          
          }
		  
	  }

}
