package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Drag_Drop_HandlingFrames {
	@Test
	public void HandlingFrames(){
    	System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
     	WebDriver driver = new ChromeDriver(); //launching the browser
     	driver.get("https://jqueryui.com/droppable/");
     	driver.manage().window().maximize(); //maximize
     	//find the frame
     	WebElement frameElement = driver.findElement(By.className("demo-frame"));
     	//switch control to the frame
     	driver.switchTo().frame(frameElement);
     	//find the draggable element
     	WebElement dragElement = driver.findElement(By.id("draggable"));
     	//find the droppable element
     	WebElement dropElement = driver.findElement(By.id("droppable"));
     	//perform the drag/drop action
     	Actions action = new Actions(driver);
     	action.dragAndDrop(dragElement, dropElement).build().perform();
     	//verify that the drop has happened successfully 
     	if (dropElement.getText().equals("Dropped!"))
     		System.out.println("Element Dropped Successfully");
     	else 
     		System.out.println("Element Drop did not happen");
	}
}

