package testCases;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CaptureScreenshot {

	@Test
	public void getScreenshot() throws IOException{
     	System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
     	WebDriver driver = new ChromeDriver(); //launching the browser
     	driver.get("https://www.calculator.net/calorie-calculator.html");
     	driver.findElement(By.linkText("BMI")).click();
     	driver.manage().window().maximize(); //maximize
     	TakesScreenshot ts = (TakesScreenshot)driver;
     	File file = ts.getScreenshotAs(OutputType.FILE);
     	FileUtils.copyFile(file, new File("C:\\Users\\phallammark\\eclipse-workspace\\seleniumProjectDay4\\src\\test\\resources\\screenCaptures\\BMIPage.png"));
     	
	}
}