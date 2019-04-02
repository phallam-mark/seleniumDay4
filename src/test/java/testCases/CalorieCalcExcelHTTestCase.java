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

import utils.ExcelUtils;
import utils.PropertyReader;

public class CalorieCalcExcelHTTestCase {
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
     	WebElement WeightTextbox = driver.findElement(By.id("cpound"));
     	WeightTextbox.clear();
     	WeightTextbox.sendKeys(record.get("weight"));
     	
     	Thread.sleep(5000);

	}
    @DataProvider
	public Object[][] getCalorieData() throws IOException{
		String ProjectPath = System.getProperty("user.dir");
		String filepath = "C:\\Users\\phallammark\\eclipse-workspace\\seleniumProjectDay4\\src\\test\\resources";
		//String filepath = ProjectPath + "/src/com/project/testdata";
		String filename = "CalorieTestData.xls";
		String sheetname ="CalorieTestSet";
		return ExcelUtils.ReadExcelDataToObjectArray(filepath, filename, sheetname);
    
    }
    
   	
}
