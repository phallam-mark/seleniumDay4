package testCases;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.PropertyReader;

public class CalorieCalcHTTestCase {
	WebDriver driver;
	@BeforeMethod
	public void LaunchBrowser() throws IOException{
     	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
     	driver = new ChromeDriver(); //launching the browser
     	//driver.get("https://www.calculator.net/calorie-calculator.html");
     	driver.get(PropertyReader.ReadProperty("appurl"));
     	driver.manage().window().maximize(); //maximize 		
	}
	
	@AfterMethod
	public void CloseBrowser(){
		if(driver!=null){
			driver.close(); //the current active browser
			driver.quit(); ///closes all open browsers opened via yout script
		}
	}
	
	@Test(dataProvider="getCalorieData")
	public void EnterCalorieDetails(Hashtable<String,String> record) throws InterruptedException{
     	WebElement ageElement = driver.findElement(By.name("cage"));
     	System.out.println("Get the default value of age Textbox : " + ageElement.getAttribute("value"));
     	ageElement.clear();
     	ageElement.sendKeys(record.get("age")); //enter 45 
     	List<WebElement> sexList = driver.findElements(By.name("csex"));
     	for(WebElement sex : sexList ){
     		if(sex.getAttribute("value").equals(record.get("sex"))){
     			if(!sex.isSelected()){
     				sex.click();
     				break;
     			}     			
     		}
     	}
     	
     	Thread.sleep(5000);

	}
    @DataProvider
	public Object[][] getCalorieData(){
/*		Object[][] data = new Object[2][2];
		data[0][0] = "45";
		data[0][1] ="f";
		data[1][0] ="56";
		data[1][1] = "m";
		
		
*/		
    	//first record set 
    	Hashtable<String,String> record1 = new Hashtable<String,String>();
    	record1.put("age", "45");
    	record1.put("sex","f");
    	
    	Hashtable<String,String> record2 = new Hashtable<String,String>();
    	record2.put("age", "56");
    	record2.put("sex","m");

    	Hashtable<String,String> record3 = new Hashtable<String,String>();
    	record3.put("age", "67");
    	record3.put("sex","f");

    	//I have to keep this in two dimensional object array
    	Object[][] data = new Object[3][1];
    	//because obj array element is now going to contain one hashtable
    	data[0][0] = record1;
    	data[1][0] = record2;
    	data[2][0] = record3;
    	return data;
	}
    
   	
}
