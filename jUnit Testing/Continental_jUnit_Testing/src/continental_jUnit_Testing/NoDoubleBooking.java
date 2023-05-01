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

public class NoDoubleBooking {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hap\\Desktop\\SE-Repo-Clone\\SE_Project\\jUnit Testing\\Continental_jUnit_Testing\\lib\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testNoDoubleBooking() throws Exception {
	  driver.get("http://ec2-18-119-119-30.us-east-2.compute.amazonaws.com/room-reservation/public/");
    Thread.sleep(1500);
    driver.findElement(By.xpath("//button[@onclick='window.location.href = `http://ec2-18-119-119-30.us-east-2.compute.amazonaws.com/room-reservation/public/rooms `']")).click();
    Thread.sleep(1500);
    driver.get("http://ec2-18-119-119-30.us-east-2.compute.amazonaws.com/room-reservation/public/rooms");
    Thread.sleep(1500);
    driver.findElement(By.id("date")).click();
    driver.findElement(By.id("date")).clear();
    driver.findElement(By.id("date")).sendKeys(Keys.ARROW_LEFT, Keys.ARROW_LEFT, "12-12-2023");
    Thread.sleep(1500);
    driver.findElement(By.id("start_time")).click();
    driver.findElement(By.id("start_time")).clear();
    driver.findElement(By.id("start_time")).sendKeys("13:00");
    Thread.sleep(1500);
    driver.findElement(By.id("end_time")).click();
    driver.findElement(By.id("end_time")).clear();
    driver.findElement(By.id("end_time")).sendKeys("14:00");
    Thread.sleep(1500);
    driver.findElement(By.id("whiteboard")).click();
    driver.findElement(By.id("capacity")).clear();
    driver.findElement(By.id("capacity")).sendKeys("2");
    driver.findElement(By.id("capacity")).click();
    driver.findElement(By.id("capacity")).clear();
    driver.findElement(By.id("capacity")).sendKeys("3");
    //ERROR: Caught exception [ERROR: Unsupported command [doubleClick | id=capacity | ]]
    driver.findElement(By.id("capacity")).clear();
    driver.findElement(By.id("capacity")).sendKeys("4");
    Thread.sleep(1500);
    driver.findElement(By.id("capacity")).click();
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(1500);    
    String res_room = (String)driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select Room'])[1]/following::th[1]")).getText();
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(1500);
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    Thread.sleep(1500);
    driver.findElement(By.id("email")).sendKeys("jdough@gmail.com");
    driver.findElement(By.id("pin")).click();
    driver.findElement(By.id("pin")).clear();
    Thread.sleep(1500);
    driver.findElement(By.id("pin")).sendKeys("1223");
    Thread.sleep(1500);
    Thread.sleep(1500);
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(1500);

    driver.findElement(By.xpath("//button[@type='button']")).click();
    Thread.sleep(1500);
    driver.get("http://ec2-18-119-119-30.us-east-2.compute.amazonaws.com/room-reservation/public/");
    Thread.sleep(1500);
    driver.findElement(By.xpath("//button[@onclick='window.location.href = `http://ec2-18-119-119-30.us-east-2.compute.amazonaws.com/room-reservation/public/rooms `']")).click();
    driver.findElement(By.id("date")).click();
    driver.findElement(By.id("date")).clear();
    Thread.sleep(1500);
    driver.findElement(By.id("date")).sendKeys(Keys.ARROW_LEFT, Keys.ARROW_LEFT, "12-12-2023");
    driver.findElement(By.id("start_time")).click();
    driver.findElement(By.id("start_time")).clear();
    driver.findElement(By.id("start_time")).sendKeys("13:00");
    Thread.sleep(1500);
    driver.findElement(By.id("end_time")).click();
    driver.findElement(By.id("end_time")).clear();
    driver.findElement(By.id("end_time")).sendKeys("14:00");
    Thread.sleep(1500);
    driver.findElement(By.id("whiteboard")).click();
    driver.findElement(By.id("capacity")).clear();
    driver.findElement(By.id("capacity")).sendKeys("2");
    driver.findElement(By.id("capacity")).click();
    driver.findElement(By.id("capacity")).clear();
    driver.findElement(By.id("capacity")).sendKeys("3");
    //ERROR: Caught exception [ERROR: Unsupported command [doubleClick | id=capacity | ]]
    driver.findElement(By.id("capacity")).clear();
    driver.findElement(By.id("capacity")).sendKeys("4");
    Thread.sleep(1500);
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    try {
    assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches(res_room));
  } catch (Error e) {
    verificationErrors.append(e.toString());
  }
  //ERROR: Caught exception [unknown command []]
    Thread.sleep(10000);
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(1500);
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    Thread.sleep(1500);
    driver.findElement(By.id("email")).sendKeys("jdough@gmail.com");
    driver.findElement(By.id("pin")).click();
    driver.findElement(By.id("pin")).clear();
    Thread.sleep(1500);
    driver.findElement(By.id("pin")).sendKeys("1223");
    Thread.sleep(1500);
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(1500);
    //ERROR: Caught exception [unknown command []]
    driver.findElement(By.xpath("//button[@type='button']")).click();
    Thread.sleep(1500);
    driver.findElement(By.xpath("//button[@onclick='window.location.href =` http://ec2-18-119-119-30.us-east-2.compute.amazonaws.com/room-reservation/public/reservations `']")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("jdough@gmail.com");
    driver.findElement(By.id("pin")).click();
    driver.findElement(By.id("pin")).clear();
    driver.findElement(By.id("pin")).sendKeys("1223");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    
    //ERROR: Caught exception [unknown command []]
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.xpath("//button[@onclick='window.location.href =` http://ec2-18-119-119-30.us-east-2.compute.amazonaws.com/room-reservation/public/reservations `']")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("jdough@gmail.com");
    driver.findElement(By.id("pin")).click();
    driver.findElement(By.id("pin")).clear();
    driver.findElement(By.id("pin")).sendKeys("1223");
    driver.findElement(By.xpath("//button[@type='submit']")).click();

    
    //ERROR: Caught exception [unknown command []]
    driver.findElement(By.xpath("//button[@type='submit']")).click();
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
