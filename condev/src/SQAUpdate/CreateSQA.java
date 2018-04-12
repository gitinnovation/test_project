package SQAUpdate;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import operation.ReadObject;



public class CreateSQA {

	
	private WebDriver driver;
	int i = 1;
	String str_BookID = null;
	String str_Chapter = null;
	String str_DisplayName = null;
	String str_Keyword = null;
	boolean IsQuestionAdded=false;

	funRepo fR = new funRepo();
	ReadObject object=new ReadObject();
	Properties P;

	public CreateSQA() throws IOException
	{
		P =  object.getObjectRepository();
	}
	@BeforeClass(alwaysRun = true)
	public void setup() throws Exception {
		System.setProperty("webdriver.chrome.driver","D:\\Automation\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "D:\\Automation\\browser_driver\\chromedriver.exe");
		driver = new ChromeDriver();
		fR.loGin(P,driver);
	}

	@Test(priority = 1, dataProvider = "SQA_DATA")
	public void CreateQuestion(String Board, String Class, String Subject, String Book, String BookId, String Chapter,
			String ChapterId, String Question, String Answer, String Keyword, String DisplayName, String BloomLevel,
			String Complexity, @Optional String QuestionImage, @Optional String AnswerImages) throws Exception {
	
		if (str_BookID != BookId && str_Chapter != Chapter && i != 1)  {  // 
			i = 1;
			if(IsQuestionAdded)
			{
			    fR.SaveSQA(P,driver, str_DisplayName, str_Keyword);
			    Thread.sleep(5000);
			}
		}
		IsQuestionAdded=false;
		if (i == 1) {
			fR.editSQA(P,driver, BookId, Chapter);
			Thread.sleep(5000);
		}
		
		
		String Url= driver.getCurrentUrl();
		System.out.println(Url);
		 //boolean CheckSQAEdit;
		// CheckSQAEdit=driver.findElement(By.xpath(".//*[@id='MainContent_SQAControl_LblSQA']")).isDisplayed();
		// System.out.println("Is SQA Element is enable : "+CheckSQAEdit);
		  if(Url.equalsIgnoreCase(P.getProperty("url")+"/Lessons/Books/ChapterList.aspx?id="+BookId)) 
		  {
			  System.out.println("Question Skipped for the Chapter==>"+Chapter);
		  } 
		  else 
		  {
			  fR.addQuestion(P,driver, Question, i, QuestionImage, Answer, BloomLevel, Complexity);
		      IsQuestionAdded=true;
			  
		  }

		//fR.addQuestion(P,driver, Question, i, QuestionImage, Answer, BloomLevel, Complexity);
		i++;
		str_BookID = BookId;
		str_Chapter = Chapter;
		str_DisplayName = DisplayName;
		str_Keyword = Keyword;
	}

	@DataProvider(name = "SQA_DATA")
	public static Object[][] readExcel() throws Exception {
		readExcel re = new readExcel();
		//return re.readXLSX("D:\\Automation\\AutoitScripts\\workspace\\cdsUpload\\src\\cdsUpload\\SQA.xlsx", "Sheet6");
		return re.readXLSX("D:\\Automation\\SQA.xlsx", "Sheet6");
	}

	@Test(priority = 2)
	public void LogOut() throws Exception {
		if(IsQuestionAdded)
		{
		     fR.SaveSQA(P,driver, str_DisplayName, str_Keyword);
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath(P.getProperty("LogoutBtn"))).click();
	}

}
