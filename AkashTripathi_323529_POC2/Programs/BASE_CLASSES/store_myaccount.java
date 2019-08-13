package BASE_CLASSES;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class store_myaccount {

WebDriver dr;

public store_myaccount(WebDriver dr) {
this.dr = dr;
PageFactory.initElements(dr, this);

}

public String get_Title()
{

return dr.getTitle();
}

@FindBy(xpath = "//*[@class = 'account']")
WebElement uName;
@FindBy(xpath = "//*[@id=\"center_column\"]/div[1]/ol/li")
WebElement error;
public String get_Text()
{

try
{

boolean b = error.isDisplayed();
if(b)
{
WebDriverWait wait = new WebDriverWait(dr,10);
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")));

return error.getText();
}
}
catch(NoSuchElementException e)
{
WebDriverWait wait = new WebDriverWait(dr,10);
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class = 'account']")));

return uName.getText();
}
WebDriverWait wait = new WebDriverWait(dr,10);
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class = 'account']")));

return uName.getText();
}



}

