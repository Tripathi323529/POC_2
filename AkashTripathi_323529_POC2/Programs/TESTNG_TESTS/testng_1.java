package TESTNG_TESTS;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BASE_CLASSES.store_homepage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class testng_1 {
	WebDriver dr;
	store_homepage homepage;
	Logger log;
	 @BeforeClass
	 public void launchBrowser() {
			System.setProperty("webdriver.chrome.driver","chromedriver_v75.exe");
			 dr= new ChromeDriver();
			  dr.get("http://automationpractice.com/index.php");
			
		}
  @Test(priority=0)
  public void test_homepage() {
	  homepage=new store_homepage(dr);
	  String ac_value=homepage.get_title();
	  
	  System.out.println("Title: " + ac_value);
	  SoftAssert sa=new SoftAssert();
	  sa.assertEquals(ac_value,"My Store");
	  log=Logger.getLogger("devpinoyLogger");
	  log.info("\n========================================================================================\n"
			  + "TC_Id: test_homepage \n"
			  +"==========================================================================================\n"
			  + "test_homepage Expected Result : My Store \n" + "test_homepage Actual Result : " + ac_value + "\n"+
			  "test_homepage TEST RESULT : PASS");
	  
	  
      
  }
  @Test(priority=1)
  public void test_homepage1() {
	  homepage=new store_homepage(dr);
	  String ac_value1=homepage.get_text();
	  System.out.println("Text: " + ac_value1);
	  SoftAssert sa=new SoftAssert();
	  sa.assertEquals(ac_value1, "Sign in");
	  log=Logger.getLogger("devpinoyLogger");
	  log.info("\n========================================================================================\n"
			  + "TC_Id: test_homepage1 \n"
			  +"==========================================================================================\n"
			  + "test_homepage1 Expected Result : Sign in \n" + "test_homepage Actual Result : " + ac_value1 + "\n"+
			  "test_homepage TEST RESULT : PASS");
	  homepage.clk_signin();
  }
 

}
