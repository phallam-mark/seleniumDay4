package testCases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.CalorieCalcPage;

public class CalorieCalcPageTestCase {
	
	@Test
	public void EnterCalorieDetailsTest(){
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");
		driver.manage().window().maximize();
		CalorieCalcPage cp = new CalorieCalcPage(driver);
		cp.EnterCalorieDetails("45", "f", "200");
	}
}
