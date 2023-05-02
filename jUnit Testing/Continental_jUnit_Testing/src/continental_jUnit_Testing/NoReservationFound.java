package continental_jUnit_Testing;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.time.Duration;

public class NoReservationFound {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
	// System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hap\\Desktop\\SE-Repo-Clone\\SE_Project\\jUnit Testing\\Continental_jUnit_Testing\\lib\\chromedriver.exe");
	System.setProperty("webdriver.chrome.driver", "lib/mac/chromedriver");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testNoReservationFound() throws Exception {
    //ERROR: Caught exception [unknown command []]
	driver.get("http://ec2-18-119-119-30.us-east-2.compute.amazonaws.com/room-reservation/public/");
	Thread.sleep(1500);
    driver.findElement(By.xpath("//button[@onclick='window.location.href =` http://ec2-18-119-119-30.us-east-2.compute.amazonaws.com/room-reservation/public/reservations `']")).click();
    Thread.sleep(1500);
    driver.get("http://ec2-18-119-119-30.us-east-2.compute.amazonaws.com/room-reservation/public/reservations");
    Thread.sleep(1500);
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    Thread.sleep(1500);
    driver.findElement(By.id("email")).sendKeys("jdough@gmail.com");
    Thread.sleep(1500);
    driver.findElement(By.id("pin")).click();
    driver.findElement(By.id("pin")).clear();
    Thread.sleep(1500);
    driver.findElement(By.id("pin")).sendKeys("1223");
    Thread.sleep(1500);
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(1500);
    String No_res = (String)driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Reservation Information'])[1]/following::p[1]")).getText();
    //ERROR: Caught exception [unknown command []]
    System.out.print(No_res);
    Assert.assertEquals(No_res, "No matching reservations could be found.");
    driver.findElement(By.xpath("//button[@onclick='window.location.href =` http://ec2-18-119-119-30.us-east-2.compute.amazonaws.com/room-reservation/public `']")).click();
    Thread.sleep(1500);
    driver.get("http://ec2-18-119-119-30.us-east-2.compute.amazonaws.com/room-reservation/public/");
    Thread.sleep(1500);
  }

  @After
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