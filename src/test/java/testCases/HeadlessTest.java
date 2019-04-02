package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeadlessTest {
	
	@Test
	public void HeadlessTestExec(){
		// instead of using chromedriver, now using HtmlUnitDriver
		HtmlUnitDriver driver = new HtmlUnitDriver();
     	driver.get("https://www.calculator.net/calorie-calculator.html");
     	driver.manage().window().maximize(); //maximize
     	System.out.println(driver.getTitle());
     	System.out.println(driver.getCurrentUrl());
     	driver.findElement(By.linkText("BMI")).click();
     	System.out.println(driver.getTitle());
     	System.out.println(driver.getCurrentUrl());
     	WebElement bmiElement = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[5]/div[1]/font[1]/b[1]"));
     	String bmiRange = bmiElement.getText();
     	System.out.println("bmi value = " + bmiRange);
     	Assert.assertEquals(bmiRange,"Normal");
	}
}
