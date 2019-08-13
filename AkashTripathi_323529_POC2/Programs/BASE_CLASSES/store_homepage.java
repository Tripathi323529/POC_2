package BASE_CLASSES;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class store_homepage {
	WebDriver dr;
	
	@FindBy(xpath="//a[@title=\"Log in to your customer account\"]")
	WebElement signin;
	
	public store_homepage(WebDriver dr) {
		this.dr=dr;
		PageFactory.initElements(dr, this);
		
	}
	public void clk_signin() {
		signin.click();
	}
	public String get_title() {
		return  dr.getTitle();
	}
	public String get_text() {
		return signin.getText();
	}
	

}
