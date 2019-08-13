package BASE_CLASSES;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class store_authenticationpage {
	WebDriver dr;
	
	
	
	public store_authenticationpage(WebDriver dr) {
		this.dr=dr;
		PageFactory.initElements(dr, this);
		
	}
//	public String get_title1() {
//		WebDriverWait wait = new WebDriverWait(dr,10);
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id=\"email\"]")));
//		System.out.println(dr.getTitle());
//		return  dr.getTitle();
//	}
	
	
	@FindBy(xpath="//*[@id='email']")
	WebElement uname;
	@FindBy(xpath="//*[@id='passwd']")
	WebElement pass;
	@FindBy(xpath="//*[@id='SubmitLogin']")
	WebElement login;
	public String do_login(String Email,String Password) {
//		String e=Email;
//		String p=Password;
		//WebDriverWait wait = new WebDriverWait(dr,10);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"email\"]")));
		String str=dr.getTitle();
		//WebDriverWait wait = new WebDriverWait(dr,10);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='email']")));
		uname.sendKeys(Email);
		pass.sendKeys(Password);
		login.click();
		return str;
		
	}
	@FindBy(xpath="//*[@class='logout']")
	WebElement logout;
	public void logout() {
		try {
			if(logout.isDisplayed())
				logout.click();
		}
		catch(NoSuchElementException e){
			
			
		}
	}
	
	

}
