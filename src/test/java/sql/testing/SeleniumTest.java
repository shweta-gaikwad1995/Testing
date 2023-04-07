package sql.testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest {
	static WebDriver driver;
	
	
	@BeforeMethod
	
	public void m1() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, InterruptedException
	{
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		Thread.sleep(10,000);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://tutorialsninja.com/demo");
	
	}
	
	@Test
	public void title()
	{
		String actualtitle=	driver.getTitle();
		System.out.println("ActualTitle : "+actualtitle);
		String expectedtitle="Your Store";
		Assert.assertEquals(actualtitle, expectedtitle,"title are equal");
	}
	
	
	
	/**
	 * Navigate to “Components’ 
	 * Menu and select “Monitors” submenu option
	 */
	@Test
	public void navigateComponenets()
	{
		WebElement compoenents=driver.findElement(By.xpath("//a[text()='Components']"));
		Actions act=new Actions(driver);
		act.moveToElement(compoenents).perform();
		//click on monitors link
	WebElement monitor=	driver.findElement(By.xpath("//a[text()='Monitors (2)']"));
			//monitor.click();
		
	JavascriptExecutor js=((JavascriptExecutor)driver);
			{
		js.executeScript("arguments[0].click()", monitor);
			}
		
			/**
			 * Note down the price of a product 
			 * in this page &amp; click on the item
			 */
			
			WebElement productPrice=driver.findElement(By.xpath("//span[text()='$110.00']"));
			String productPriceRate=productPrice.getText();
			System.out.println(" Product Price "+productPriceRate);
	
			//click on the item
			WebElement ClickProduct=driver.findElement(By.xpath("//h4//a[@href='http://tutorialsninja.com/demo/index.php?route=product/product&path=25_28&product_id=42']"));
			ClickProduct.click();
			
/**
 * Scroll down to “Available Options” section 
 * and select radio button – Large, Checkbox 3
 */
	WebElement AvailableOption=driver.findElement(By.xpath("//h3[text()='Available Options']"));		
	
	JavascriptExecutor js1=((JavascriptExecutor)driver);
			{
		js1.executeScript("arguments[0].scrollIntoView(true)", AvailableOption);
			}	
		
			
			/**
			 * select radio button – Large, Checkbox 3 
			 */
			WebElement Large_RadioButton=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[2]/div[1]/div/div/label/input"));
			Large_RadioButton.click();
			
			List<WebElement> allcheckboxes=driver.findElements(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[2]/div[2]/div"));
	       System.out.println("Size of Allcheckboxes " +allcheckboxes.size());
	      
	    	 WebElement checkbox3=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[2]/div[2]/div/div[2]/label/input"));
	    	 checkbox3.click();
	    	 
	    	 //Enter Textarea as “Atmosol Interview”
	    	 
	    	 WebElement Textarea=driver.findElement(By.xpath("//input[@id='input-option208']"));
	    	 Textarea.sendKeys("Atmosol Interview");
	    	 
	    	 //Select “Blue” colour in “Select” dropdown
	    	 
	    	 WebElement dropdrown=driver.findElement(By.xpath("//select[@id='input-option217']"));
	    	 Select dropselect=new Select(dropdrown);
	    	 dropselect.selectByIndex(1);
	    	 
	    	 //Enter Textarea as “Atmosol Interview”
	    	 WebElement Textarea2=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[2]/div[5]/textarea"));
	    	 Textarea2.sendKeys("Atmosol Interview");
	    	 
	    	 //Update “Qty” as 1
	    	 WebElement quantity=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[2]/div[10]/input[1]"));
	    	 quantity.clear();
	    	 quantity.sendKeys("1");
	    	 
	    	 //Click “Add to Cart” button
	    	 WebElement AddToCart=driver.findElement(By.xpath("//button[text()='Add to Cart']"));
	    	  AddToCart.click();
	       
	    	
			
	
	}
	


}
	

