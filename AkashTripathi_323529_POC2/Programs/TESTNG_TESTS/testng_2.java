package TESTNG_TESTS;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sun.imageio.plugins.common.ReaderUtil;

import BASE_CLASSES.store_authenticationpage;
import BASE_CLASSES.store_myaccount;
import UTILITIES.Excel;


public class testng_2 extends testng_1{

store_myaccount ac;
SoftAssert sa;
store_authenticationpage ap;
Excel re;
String [][] logintestdata;

@BeforeClass
public void bc()
{
re = new Excel();
logintestdata = re.readExcel();
}



@Test(dataProvider = "logindataprovider", priority=3)
 public void logInTest(String emailId, String pwd, String er)
 {
 ap = new store_authenticationpage(dr);
 String str1 = ap.do_login(emailId, pwd);
 sa = new SoftAssert();
 sa.assertEquals(str1, "Login - My Store");
 log=Logger.getLogger("devpinoyLogger");
 log.info("\n==========================================================================\n"
 	+ "-------------------------------Login Page Title Test--------------------------------\n"
 	+ "============================================================================\n");
   log.info("Expected Value : Login - My Store");
 	log.info(" Actual Value : "+str1);
 	log.info(" Test Result: Passed");
 ac = new store_myaccount(dr);
 accountTest();
 verifyName(er);
 ap.logout();
 

 }
 

 
 @DataProvider(name="logindataprovider")
 public String[][] testData(){

 return logintestdata;
 
 }
 
 public void accountTest()
 {
 String str2 = ac.get_Title();
 sa = new SoftAssert();
 sa.assertEquals(str2, "My account - My Store");
 log=Logger.getLogger("devpinoyLogger");
 log.info("\n===================================================================================\n"
 	+ "-----------------------------------Account Test----------------------------------\n"
 	+ "==================================================================================\n");
 log.info("Expected Value : My account - My Store");
 	log.info(" Actual Value : "+str2);
 	log.info(" Test Result: Passed");
 
 }

 public void verifyName(String er)
 {
 String str2 = ac.get_Text();
 sa = new SoftAssert();
 sa.assertEquals(str2,er);
 log=Logger.getLogger("devpinoyLogger");
 log.info("\n===============================================================================\n"
 	+ "-------------------------------Profile Name Test--------------------------------\n"
 	+ "==============================================================================\n");
 log.info("Expected Value : "+er);
 	log.info(" Actual Value : "+str2);
 	log.info(" Test Result: Passed");
 
 }
 
}
