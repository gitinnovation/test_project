package Upload;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MCQ {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://10.0.20.15:9797/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testMCQ() throws Exception {
    driver.get(baseUrl + "/Lessons/Books/AddQuestion.aspx?TopicID=247767&Type=HOT&RID=CDS2000101880356&Subject=195&MediaType=SWF");
    driver.findElement(By.id("MainContent_AddToQuestionBank1_QuestionEditor1_RadioButtonList1_1")).click();
    new Select(driver.findElement(By.id("MainContent_AddToQuestionBank1_QuestionEditor1_ddlBloomLevel"))).selectByVisibleText("1 - Remember");
    driver.findElement(By.id("MainContent_AddToQuestionBank1_QuestionEditor1_rbComplexity_0")).click();
    driver.findElement(By.cssSelector("span.RBEasy > label")).click();
    driver.findElement(By.id("MainContent_AddToQuestionBank1_QuestionEditor1_FileUpload1")).clear();
    driver.findElement(By.id("MainContent_AddToQuestionBank1_QuestionEditor1_FileUpload1")).sendKeys("D:\\test\\CMS2000180588879\\Current\\Source\\CLASS 1 - EDAC\\TBC1CH2 Knowing Computer parts and their Functions\\Lab Resources and Images\\Session 5\\1.png");
    driver.findElement(By.id("MainContent_AddToQuestionBank1_QuestionEditor1_RadioButton1")).click();
    driver.findElement(By.id("btnSubmit")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
