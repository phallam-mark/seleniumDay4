package testCases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HandleAjax {
	
	//one example of where ajax is used is in 'auto-suggest' lists
	@Test
	public void HandleAjaxMethod(){
     	System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
     	WebDriver driver = new ChromeDriver(); //launching the browser
     	driver.get("http://www.google.com");
     	driver.manage().window().maximize(); //maximize
     	driver.findElement(By.name("q")).sendKeys("kea");
     	WebDriverWait wait = new WebDriverWait(driver,30);
     	try{
     		//need to wait for list of suggestions to appear after keying in
     		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@role='listbox']/li[1]")));
     		List <WebElement> list = driver.findElements(By.xpath("//*[@role='listbox']/li"));
     		for(WebElement element : list){
     			if(element.getText().equals("keanu reeves")){
     				element.click();
     				break;
     			}
     		}
     	}catch(NoSuchElementException e){
     		System.out.println("No Such ELement Found");
     }
}
	
}
