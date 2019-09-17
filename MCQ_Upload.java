package Upload;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MCQ_Upload {
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
  public void testMCQUpload() throws Exception {
    driver.get(baseUrl + "/Account/Login.aspx?ReturnUrl=%2f");
    driver.findElement(By.id("LoginUser_UserName")).clear();
    driver.findElement(By.id("LoginUser_UserName")).sendKeys("cb_MCQ");
    driver.findElement(By.id("LoginUser_UserName")).clear();
    driver.findElement(By.id("LoginUser_UserName")).sendKeys("cb_MCQ");
    driver.findElement(By.id("LoginUser_Password")).clear();
    driver.findElement(By.id("LoginUser_Password")).sendKeys("automation");
    driver.findElement(By.id("LoginUser_Password")).clear();
    driver.findElement(By.id("LoginUser_Password")).sendKeys("automation");
    driver.findElement(By.id("LoginButton")).click();
    driver.findElement(By.id("LoginButton")).click();
    driver.findElement(By.id("MainContent_LoginView1_LB_MyPage_List_dl_Books_BookInfo1_0_imgBook_0")).click();
    driver.findElement(By.id("MainContent_LoginView1_LB_MyPage_List_dl_Books_BookInfo1_0_imgBook_0")).click();
    driver.findElement(By.xpath("//table[@id='DataList1']/tbody/tr/td/div/h3/a")).click();
    driver.findElement(By.xpath("//table[@id='DataList1']/tbody/tr/td/div/h3/a")).click();
    driver.findElement(By.cssSelector("#__sizzle__ > td > #DivTopic")).click();
    driver.findElement(By.id("ctl00_MainContent_TopicLesson1_McqGrid_ctl02_ElementInfo1_lnkEdit")).click();
    driver.findElement(By.id("ctl00_MainContent_TopicLesson1_McqGrid_ctl02_ElementInfo1_lnkEdit")).click();
    driver.findElement(By.id("MainContent_MCQ1_SearchKeyWord_txtKeywords")).clear();
    driver.findElement(By.id("MainContent_MCQ1_SearchKeyWord_txtKeywords")).sendKeys("This is Automation testing recording content");
    driver.findElement(By.id("MainContent_MCQ1_SearchKeyWord_txtKeywords")).clear();
    driver.findElement(By.id("MainContent_MCQ1_SearchKeyWord_txtKeywords")).sendKeys("This is Automation testing recording content");
    driver.findElement(By.id("MainContent_MCQ1_EditElementName_txtElementName")).clear();
    driver.findElement(By.id("MainContent_MCQ1_EditElementName_txtElementName")).sendKeys("This is Automation testing recording content");
    driver.findElement(By.id("MainContent_MCQ1_EditElementName_txtElementName")).clear();
    driver.findElement(By.id("MainContent_MCQ1_EditElementName_txtElementName")).sendKeys("This is Automation testing recording content");
    driver.findElement(By.id("rblMediaType_1")).click();
    driver.findElement(By.id("rblMediaType_1")).click();
    driver.findElement(By.id("rblMediaType_0")).click();
    driver.findElement(By.id("rblMediaType_0")).click();
    driver.findElement(By.linkText("Edit")).click();
    driver.findElement(By.linkText("Edit")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp | Win | 30000]]
    driver.findElement(By.id("MainContent_MCQ1_SearchKeyWord_txtKeywords")).clear();
    driver.findElement(By.id("MainContent_MCQ1_SearchKeyWord_txtKeywords")).sendKeys("This is Automation testing recording content");
    driver.findElement(By.id("MainContent_MCQ1_SearchKeyWord_txtKeywords")).clear();
    driver.findElement(By.id("MainContent_MCQ1_SearchKeyWord_txtKeywords")).sendKeys("This is Automation testing recording content");
    driver.findElement(By.id("MainContent_MCQ1_EditElementName_txtElementName")).clear();
    driver.findElement(By.id("MainContent_MCQ1_EditElementName_txtElementName")).sendKeys("This is Automation testing recording content");
    driver.findElement(By.id("MainContent_MCQ1_EditElementName_txtElementName")).clear();
    driver.findElement(By.id("MainContent_MCQ1_EditElementName_txtElementName")).sendKeys("This is Automation testing recording content");
    driver.findElement(By.id("btnSave")).click();
    driver.findElement(By.id("btnSave")).click();
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
