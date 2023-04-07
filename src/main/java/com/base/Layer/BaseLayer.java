package com.base.Layer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseLayer {

	public static WebDriver driver;
	public static Properties prop;
	public static ThreadLocal<WebDriver> tdriver=new ThreadLocal<WebDriver>();
	
	public BaseLayer() throws IOException
	{
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream(System.getProperty("user.dir")
					+"/src/main/java/com/config/properties/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
		}
	
	}
	
	public Properties intialization()
	{
	String browserName=	prop.getProperty("browser");
	if(browserName.equals("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	return prop;
	}
	
	public WebDriver tdriver()
	{
		return tdriver.get();
	}
}
