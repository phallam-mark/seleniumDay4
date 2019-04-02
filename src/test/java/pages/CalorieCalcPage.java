package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalorieCalcPage {
	
	WebDriver driver;
	
	@FindBy(id="cage")
	public WebElement ageTextbox;
     
	@FindBy(name="csex")
	public List<WebElement> sexList;
	
	@FindBy(id="cpound")
	public WebElement weightTextbox;
	
	public CalorieCalcPage(WebDriver driver){
		this.driver = driver;
		//to initialize all the page objects / elements you need to call the PageFactory method
		PageFactory.initElements(driver, this);
	}
	
	public void EnterCalorieDetails(String age,String sex,String weight)
	{
	   ageTextbox.clear();
	   ageTextbox.sendKeys(age);
	   
	   for(WebElement element : sexList){
		   if(element.getAttribute("value").equals(sex)){
			   if(!element.isSelected()){
				   element.click();
				   break;
			   }
		   }
	   }
	   
	   weightTextbox.clear();
	   weightTextbox.sendKeys(weight);
	}
	

}
